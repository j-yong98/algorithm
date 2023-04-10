package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {
    final int BLANK = 0;
    final int BABE = 9;
    int n;
    int[][] arr;
    int[] pos;
    int size = 2;
    int eatFish = 0;
    int time = 0;

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n && (arr[y][x] == BLANK || arr[y][x] <= size);
    }

    private boolean eat() {
        List<int[]> canEat = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> q = new LinkedList<>();
        int[] minDist = new int[]{25, 25, Integer.MAX_VALUE};
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        q.add(new int[]{pos[0], pos[1], 0});
        visited[pos[0]][pos[1]] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int y = p[0] + dy[i];
                int x = p[1] + dx[i];
                if (inRange(y, x) && !visited[y][x]) {
                    if (arr[y][x] != BLANK && arr[y][x] < size)
                        canEat.add(new int[]{y, x, p[2] + 1});
                    visited[y][x] = true;
                    q.add(new int[]{y, x, p[2] + 1});
                }
            }
        }
        if (canEat.size() != 0) {
            Collections.sort(canEat, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[2] == o2[2]) {
                        if (o1[0] == o2[0])
                            return o1[1] - o2[1];
                        return o1[0] - o2[0];
                    }
                    return o1[2] - o2[2];
                }
            });
            int[] info = canEat.get(0);
            time += info[2];
            arr[info[0]][info[1]] = BLANK;
            pos[0] = info[0];
            pos[1] = info[1];
            eatFish++;
            return true;
        }
        return false;
    }

    /**
     * 아기 상어
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == BABE) {
                    pos = new int[]{i, j};
                    arr[i][j] = 0;
                }
            }
        }
        while (eat()) {
            if (eatFish == size) {
                size++;
                eatFish = 0;
            }
        }
        System.out.println(time);
    }
}
