package baekjoon;

import java.io.*;

public class BOJ1788 {
    final int MAX = 1_000_000;
    int n;
    long[] dp = new long[MAX + 1];
    /**
     * 피보나치 수의 확장
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int ans = 0;
        dp[0] = 0;
        dp[1] = 1;
        if (n != 0) {
            if (n > 0)
                ans = 1;
            else {
                ans = n % 2 == 0 ? -1 : 1;
                n *= -1;
            }
        }
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
        bw.write(ans + "\n");
        bw.write(Math.abs(dp[n]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
