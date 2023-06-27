package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ14442 {
    final int MAX = 1_000_000_000;
    final int WALL = 1;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int n, m, k;
    int[][] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                arr[i][j] = str.charAt(j) - '0';
        }
        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[k + 1][n][m];
        int[][][] dist = new int[k + 1][n][m];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], MAX);
        }

        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x)) continue;
                if (arr[y][x] == WALL && pos[2] < k && !visited[pos[2] + 1][y][x]) {
                    visited[pos[2] + 1][y][x] = true;
                    dist[pos[2] + 1][y][x] = dist[pos[2]][pos[0]][pos[1]] + 1;
                    q.add(new int[]{y, x, pos[2] + 1});
                }
                else if (!visited[pos[2]][y][x] && arr[y][x] != WALL) {
                    visited[pos[2]][y][x] = true;
                    dist[pos[2]][y][x] = dist[pos[2]][pos[0]][pos[1]] + 1;
                    q.add(new int[]{y, x, pos[2]});
                }
            }
        }
        int res = MAX;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dist[i][n - 1][m - 1]);
        }
        return res == MAX ? -1 : res;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
