package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14728 {
    int N, T;

    /**
     * 벼락 치기
     * dp 배낭 문제 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[] dp = new int[T + 1];
        int[] time = new int[N + 1];
        int[] score = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = T; j >= 1; j--) {
                if (time[i] > j) continue;
                dp[j] = Math.max(dp[j], dp[j - time[i]] + score[i]);
            }
        }
        System.out.println(dp[T]);
    }
}
