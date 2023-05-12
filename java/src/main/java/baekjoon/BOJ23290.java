package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ23290 {
    final int[] dy = {-1, 0, 1, 0};
    final int[] dx = {0, -1, 0, 1};
    final int SIZE = 4;
    int M, S;

    List<Integer>[][] fishes = new List[SIZE + 1][SIZE + 1];
    int[] shark = new int[2];
    int[][] smell = new int[SIZE + 1][SIZE + 1];
    boolean[][] visited = new boolean[SIZE + 1][SIZE + 1];
    Deque<int[]> copy = new ArrayDeque<>();
    int max;
    int[] moving = new int[3];
    /**
     * 마법사 상어와 복제
     **/
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++)
                fishes[i][j] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            fishes[y][x].add(d);
        }
        st = new StringTokenizer(br.readLine());
        shark[0] = Integer.parseInt(st.nextToken());
        shark[1] = Integer.parseInt(st.nextToken());

        for (int s = 0; s < S; s++) {
            copyFishes();
            moveFishes();
            moveShark();
            pasteFishes();
        }

        int ans = 0;
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (fishes[i][j].isEmpty()) continue;
                ans += fishes[i][j].stream().count();
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        return ans;
    }

    private void moveShark() {
        max = -1;
        int[] tmp = new int[3];
        chooseMoving(0, tmp);
        for (int i = 0; i < 3; i++) {
            int dir = moving[i];
            shark[0] = shark[0] + dy[dir];
            shark[1] = shark[1] + dx[dir];
            if (fishes[shark[0]][shark[1]].isEmpty()) continue;
            smell[shark[0]][shark[1]] = 3;
            fishes[shark[0]][shark[1]].clear();
        }
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (smell[i][j] > 0)
                    smell[i][j]--;
            }
        }
    }

    private void chooseMoving(int l, int[] tmp) {
        if (l == 3) {
            for (int i = 1; i <= SIZE; i++)
                Arrays.fill(visited[i], false);
            int y = shark[0];
            int x = shark[1];
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                y = y + dy[tmp[i]];
                x = x + dx[tmp[i]];
                if (!inRange(y, x))
                    return ;
                if (!fishes[y][x].isEmpty() && !visited[y][x]) {
                    visited[y][x] = true;
                    cnt += fishes[y][x].stream().count();
                }
            }
            if (cnt > max) {
                max = cnt;
                for (int i = 0; i < 3; i++)
                    moving[i] = tmp[i];
            }
            return ;
        }
        for (int i = 0; i < 4; i++) {
            tmp[l] = i;
            chooseMoving(l + 1, tmp);
        }
    }

    private void moveFishes() {
        List<Integer>[][] tmp = new ArrayList[SIZE + 1][SIZE + 1];
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++)
                tmp[i][j] = new ArrayList<>();
        }

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (fishes[i][j].isEmpty()) continue;
                for (Integer fish : fishes[i][j]) {
                    int[] move = move(i, j, fish);
                    tmp[move[0]][move[1]].add(move[2]);
                }
            }
        }

        fishes = tmp;
    }

    private int[] move(int y, int x, Integer fish) {
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int yy = y + dy[fish];
        int xx = x + dx[fish];
        int cnt = 0;
        while ((!inRange(yy, xx) || smell[yy][xx] != 0 || (shark[0] == yy && shark[1] == xx)) && cnt < 8) {
            fish = (fish - 1 + 8) % 8;
            yy = y + dy[fish];
            xx = x + dx[fish];
            cnt++;
        }
        if (cnt < 8) {
            y = yy;
            x = xx;
        }
        return new int[]{y, x, fish};
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= SIZE && x >= 1 && x <= SIZE;
    }

    private void copyFishes() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++)
                if (!fishes[i][j].isEmpty()) {
                    for (Integer fish : fishes[i][j])
                        copy.add(new int[]{i, j, fish});
                }
        }
    }

    private void pasteFishes() {
        while(!copy.isEmpty()) {
            int[] fish = copy.pollFirst();
            fishes[fish[0]][fish[1]].add(fish[2]);
        }
    }
}
