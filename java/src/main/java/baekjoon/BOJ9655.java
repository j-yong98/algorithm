package baekjoon;

import java.io.*;

public class BOJ9655 {
    final int MAX = 1_000;

    int n;
    int[] dp = new int[MAX + 1];
    /**
     * 돌 게임
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = Math.min(dp[i - 1] + 1, dp[i - 3] + 1);
        String ans = dp[n] % 2 == 1 ? "SK" : "CY";
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
