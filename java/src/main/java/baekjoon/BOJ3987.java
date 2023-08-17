package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3987 {
    final char BLACK_HOLE = 'C';
    final int[] DY = {-1, 0, 1, 0};
    final int[] DX = {0, 1, 0, -1};
    int N, M;
    char[][] arr;
    int y, x;
    int ans = 0;
    char ansDir;
    char startDir;
    boolean[][] visited;

    /**
     * 보이저 1호
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = line.charAt(j);
        }
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int yy = y + DY[i];
            int xx = x + DX[i];
            startDir = getDir(i);
            simulate(yy, xx, i, 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ansDir).append("\n");
        sb.append(ans == Integer.MAX_VALUE ? "Voyager" : ans);
        System.out.println(sb);
    }

    private void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(visited[i][j] ? '*' : '-');
            }
            System.out.println();
        }
        System.out.println();
    }

    private char getDir(int dir) {
        if (dir == 0)
            return 'U';
        if (dir == 1)
            return 'R';
        if (dir == 2)
            return 'D';
        return 'L';
    }

    private void simulate(int y, int x, int dir, int time) {
        if (!inRange(y, x) || arr[y][x] == BLACK_HOLE) {
            if (ans < time) {
                ans = time;
                ansDir = startDir;
            }
            return;
        }
        if (time > N * M * 2) {
            if (ans != Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                ansDir = startDir;
            }
            return;
        }
        visited[y][x] = true;
        //위 0 오른쪽 1 아래 2 왼쪽 3
        if (arr[y][x] == '\\') //0 -> 3 1 -> 2 2 -> 3 3 -> 0
            dir ^= 3;
        else if (arr[y][x] == '/')// 0 -> 1, 1 -> 0, 2 -> 3, 3 -> 2
            dir ^= 1;
        int yy = y + DY[dir];
        int xx = x + DX[dir];
        simulate(yy, xx, dir, time + 1);
        visited[y][x] = false;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
