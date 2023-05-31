package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ10844 {
    final int DIV = 1_000_000_000;
    final int DIGIT = 10;
    int n;
    long[][] dp;
    /**
     * 쉬운 계단 수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][DIGIT];
        for (int i = 1; i < DIGIT; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < DIGIT; j++)
                if (j == 0)
                    dp[i][j] = dp[i - 1][1];
                else if (j == DIGIT - 1)
                    dp[i][j] = dp[i - 1][8];
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIV;
        }
        bw.write((Arrays.stream(dp[n]).sum() % DIV) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
