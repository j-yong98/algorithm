package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16493 {
    int N, M;
    int[] dp;
    int[] days;
    int[] pages;

    /**
     * 최대 페이지 수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        days = new int[M + 1];
        pages = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++) {
            for (int j = N; j >= 1; j--) {
                if (days[i] > j) continue;
                dp[j] = Math.max(dp[j], dp[j - days[i]] + pages[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
