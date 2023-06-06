package baekjoon;

import java.io.*;

public class BOJ10942 {
    int n, m;
    int[] arr;
    boolean[][] dp;
    /**
     * 팰린드롬?
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new boolean[n + 1][n + 1];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);

        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1])
                dp[i][i + 1] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j] && dp[i + 1][j - 1])
                    dp[i][j] = true;
            }
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            bw.write((dp[s - 1][e - 1] == true ? 1 : 0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
