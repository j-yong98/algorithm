package others;

import java.io.*;

public class Problem164 {
    int T;
    int n, m;
    boolean[][] arr;
    boolean[] visited;
    int ans;
    /**
     * 창용 마을 무리의 개수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            arr = new boolean[n + 1][n + 1];
            visited = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                arr[a][b] = arr[b][a] = true;
            }
            ans = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                ans++;
                dfs(i);
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int s) {
        for (int i = 1; i <= n; i++) {
            if (i == s || visited[i]) continue;
            if (arr[s][i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
