package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ22115 {
    final int MAX = 100_000_000;
    int N, K;
    int[] arr;
    int[] dp;
    /**
     * 창영이와 커피
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[K + 1];
        st = new StringTokenizer(br.readLine());
        if (K == 0)
            System.out.println(0);
        else {
            Arrays.fill(dp, MAX);
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            dp[0] = 0;
            for (int i = 1; i <= N; i++) {
                for (int k = K; k >= 1; k--) {
                    if (k < arr[i]) break;
                    dp[k] = Math.min(dp[k], dp[k - arr[i]] + 1);
                }
            }
            System.out.println(dp[K] == MAX ? -1 : dp[K]);
        }
        br.close();
    }
}
