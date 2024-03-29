package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3067 {
    /**
     * Coins
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int coin = Integer.parseInt(st.nextToken());
                coins[i] = coin;
            }
            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j - coins[i] < 0) continue;
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(dp[target]);
        }
    }
}
