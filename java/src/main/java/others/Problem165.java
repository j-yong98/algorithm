package others;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem165 {
    final int WALL = 1;
    final int SWIRL = 2;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int T;
    int n;
    int[][] arr;
    boolean[][] visited;
    int[] start = new int[2];
    int[] end = new int[2];
    int ans;

    /**
     * 수영대회 결승전
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++)
                    arr[i][j] = Integer.parseInt(line[j]);
            }
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < 2; i++)
                start[i] = Integer.parseInt(line[i]);
            line = br.readLine().split(" ");
            for (int i = 0; i < 2; i++)
                end[i] = Integer.parseInt(line[i]);
            ans = Integer.MAX_VALUE;
            bw.write("#" + t + " " + swim() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int swim() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[0] == end[0] && pos[1] == end[1])
                return pos[2];
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x) || visited[y][x] || arr[y][x] == WALL) continue;
                if (arr[y][x] == SWIRL && pos[2] % 3 != 2)
                        q.add(new int[]{pos[0], pos[1], pos[2] + 1});
                else {
                    visited[y][x] = true;
                    q.add(new int[]{y, x, pos[2] + 1});
                }
            }
        }
        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
