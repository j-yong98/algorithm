package others;

import java.io.*;
import java.util.Arrays;

public class Problem156 {
    int T;
    int n;
    int[][] arr;
    boolean[] visited;
    /**
     * 문제이름
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            arr = new int[n + 1][n + 1];
            visited = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                line = br.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                arr[u][v] = 1;
                arr[v][u] = 1;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                Arrays.fill(visited, false);
                visited[i] = true;
                ans = Math.max(ans, dfs(i));
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private int dfs(int s) {
        int max = 1;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[s][i] == 1) {
                visited[i] = true;
                int res = dfs(i) + 1;
                visited[i] = false;
                max = Math.max(max, res);
            }
        }
        return max;
    }
}
