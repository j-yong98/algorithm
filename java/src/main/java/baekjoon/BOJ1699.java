package baekjoon;

import java.io.*;

public class BOJ1699 {
    final int MAX = 100_000;

    int n;
    int[]dp = new int[MAX + 1];
    /**
     * 제곱수의 합
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
