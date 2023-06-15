package baekjoon;

import java.io.*;

public class BOJ9466 {
    int n;
    int[] arr;
    boolean[] visited;
    boolean[] finished;
    int ans;

    /**
     * 텀 프로젝트
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            ans = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            String[] line = br.readLine().split(" ");
            for (int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(line[i - 1]);
            for (int i = 1; i <= n; i++) {
                if (!visited[i])
                    dfs(i);
            }
            bw.write((n - ans) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int num) {
        visited[num] = true;
        int next = arr[num];
        if (!visited[next])
            dfs(next);
        else if (!finished[next]) {
            for (int i = next; i != num; i = arr[i])
                ans++;
            ans++;
        }
        finished[num] = true;
    }
}
