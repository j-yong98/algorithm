package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1600 {
    final int MAX = 10_000_000;
    final int OBSTACLE = 1;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int[] h_dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    final int[] h_dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int k;
    int w, h;
    int[][] arr;

    /**
     * 말이 되고픈 원숭이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        w = Integer.parseInt(line[0]);
        h = Integer.parseInt(line[1]);
        arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < w; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }
        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs() {
        int res = MAX;
        boolean[][][] visited = new boolean[h][w][k + 1];

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[0] == h - 1 && pos[1] == w - 1)
                res = Math.min(res, pos[2]);
            if (pos[3] < k) {
                for (int i = 0; i < 8; i++) {
                    int y = pos[0] + h_dy[i];
                    int x = pos[1] + h_dx[i];
                    if (inRange(y, x) && arr[y][x] != OBSTACLE && !visited[y][x][pos[3] + 1]) {
                        visited[y][x][pos[3] + 1] = true;
                        q.add(new int[]{y, x, pos[2] + 1, pos[3] + 1});
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && arr[y][x] != OBSTACLE && !visited[y][x][pos[3]]) {
                    visited[y][x][pos[3]] = true;
                    q.add(new int[]{y, x, pos[2] + 1, pos[3]});
                }
            }
        }
        return res == MAX ? -1 : res;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}
