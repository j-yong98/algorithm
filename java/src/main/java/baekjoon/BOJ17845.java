package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17845 {
    int N, K;

    /**
     * 수강 과목
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        int[] time = new int[K + 1];
        int[] score = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= K; i++) {
            for (int j = N; j >= 1; j--) {
                if (time[i] > j) continue;
                dp[j] = Math.max(dp[j], dp[j - time[i]] + score[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
