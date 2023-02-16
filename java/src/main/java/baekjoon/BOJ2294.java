package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2294 {
    int n, k;
    int[] coins;
    int[] dp;
    final int MAX = 99999999;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1];
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= k; i++)
            dp[i] = MAX;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coins[i])
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        System.out.println(dp[k] == MAX ? -1 : dp[k]);
    }
}
