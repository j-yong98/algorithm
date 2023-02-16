package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    final int MIN = -10000000;
    int n, k;
    int[] weight;
    int[] value;
    int[] dp;
    public void init() {
        for (int i = 0; i <= k; i++) {
            dp[i] = MIN;
        }
        dp[0] = 0;
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        weight = new int[n];
        value = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 0; j--) {
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[k]);
    }
}
