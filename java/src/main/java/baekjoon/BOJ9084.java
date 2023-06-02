package baekjoon;

import java.io.*;

public class BOJ9084 {

    /**
     *  동전
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < N; i++)
                coins[i] = Integer.parseInt(line[i]);
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (coins[i] > j)
                        continue;
                    dp[j] += dp[j - coins[i]];
                }
            }
            bw.write(dp[M] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    /**
     * ex)
     * 1 3
     * m = 10
     * 1 1 2 3 4 6
     *
     * dp[i] += dp[i - coins[j]]
     * 4
     * 1 1 1 1
     * 1 3
     *
     * 5
     * 1 1 1 1 1
     * 1 1 3
     *
     * 6
     * 1 1 1 1 1 1
     * 1 1 1 3
     * 3 3
     */
}
