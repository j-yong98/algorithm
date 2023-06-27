package others;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem162 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int MAX = 1_000_000_000;
    int T;
    int n;
    int[][] arr;
    /**
     * 보급로
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++)
                    arr[i][j] = line.charAt(j) - '0';
            }
            bw.write("#" + t + " " + getMinPath() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int getMinPath() {
        int[][] dist = new int[n][n];
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], MAX);
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && dist[pos[0]][pos[1]] + arr[y][x] < dist[y][x]) {
                    q.add(new int[]{y, x});
                    dist[y][x] = dist[pos[0]][pos[1]] + arr[y][x];
                }
            }
        }
        return dist[n - 1][n - 1];
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
