package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18427 {
    final int MOD = 10_007;
    int N, M, H;
    List<Integer>[] blocks;
    int[] dp;

    /**
     * 함께 블럭 쌓기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        blocks = new List[N + 1];
        dp = new int[H + 1];
        for (int i = 1; i <= N; i++)
            blocks[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int h = H; h >= 1; h--) {
                for (int j = 0; j < blocks[i].size(); j++) {
                    if (h < blocks[i].get(j)) continue;
                    dp[h] = (dp[h] + dp[h - blocks[i].get(j)]) % MOD;
                }
            }
        }
        System.out.println(dp[H]);
    }
}
