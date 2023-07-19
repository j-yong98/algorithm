package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ11404 {
    final int MAX = 10_000_000;
    int n, m;
    int[][] dist;
    /**
     * 플로이드
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(dist[i], 1, n + 1, MAX);
        for (int i = 1; i <= n; i++)
            dist[i][i] = 0;
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            dist[u][v] = Math.min(dist[u][v], w);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                sb.append(dist[i][j] == MAX ? 0 : dist[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
