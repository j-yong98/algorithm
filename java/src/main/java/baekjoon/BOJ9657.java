package baekjoon;

import java.io.*;

public class BOJ9657 {
    final int MAX = 1000;
    int n;
    boolean[] dp = new boolean[MAX + 1];
    /**
     * 돌 게임 3
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp[1] = dp[3] = dp[4] = true;
        dp[2] = false;
        for (int i = 5; i <= n; i++) {
            if (dp[i - 1] & dp[i - 3] & dp[i - 4])
                dp[i] = false;
            else dp[i] = true;
        }
        String ans = dp[n] == true ? "SK" : "CY";
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
