package baekjoon;

import java.io.*;

public class BOJ11727 {
    final int MAX = 1000;
    int n;
    int[] dp = new int[MAX + 1];
    /**
     * 2xn 타일링 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10_007;
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
