package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11057 {
    int N;
    int[][] dp;
    /**
     * 오르막 수 구하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10_007;
            }
        }
        System.out.println(Arrays.stream(dp[N]).sum() % 10_007);
        br.close();
    }
}
