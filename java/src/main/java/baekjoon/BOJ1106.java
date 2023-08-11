package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    final int MAX = 10_000_000;
    int C, N;
    int[] costs;
    int[] people;
    int[] dp;

    /**
     * 호텔
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        C = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        dp = new int[C + 101];
        costs = new int[N + 1];
        people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            costs[i] = c;
            people[i] = p;
        }
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= C + 100; i++) {
            for (int j = 1; j <= N; j++) {
                if (i < people[j]) continue;
                dp[i] = Math.min(dp[i], dp[i - people[j]] + costs[j]);
            }
        }
        System.out.println(Arrays.stream(dp, C, dp.length).min().getAsInt());
    }
}
