package baekjoon;

import java.io.*;

public class BOJ12852 {
    int n;
    int[] dp;
    int[] path;
    /**
     * 1로 만들기2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        path = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }
        bw.write(dp[n] + "\n");
        bw.write(n + " ");
        while (n > 1) {
            bw.write(path[n] + " ");
            n = path[n];
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
