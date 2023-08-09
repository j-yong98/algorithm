package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    final int MOD = 9901;

    int N;
    int[][] dp;

    /**
     * 동물원
     * 아무것도 안넣는 경우 한마리 넣는 경우 두마리 넣는 경우
     * 세 개의 경우를 잘 생각해 기록
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++)
            sum = (sum + dp[N][i]) % MOD;
        System.out.println(sum);
    }
}
