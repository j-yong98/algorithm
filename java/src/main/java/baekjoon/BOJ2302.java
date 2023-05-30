package baekjoon;

import java.io.*;

public class BOJ2302 {
    final int MAX = 40;
    int n, m;
    int[] dp = new int[MAX + 1];
    /**
     * 극장 좌석
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        int ans = 1;
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            ans *= dp[num - tmp - 1];
            tmp = num;
        }
        ans *= dp[n - tmp];
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    /**
     * 1
     * 1
     *
     * 2
     * 1 2
     * 2 1
     *
     * 3
     * 1 2 3
     * 2 1 3
     * 1 3 2
     *
     * 4
     * 1 2 3 4
     * 1 3 2 4
     * 1 2 4 3
     * 2 1 4 3
     * 2 1 3 4
     *
     * 5
     * 1 2 3 4 5
     * 1 2 3 5 4
     * 1 3 2 4 5
     * 1 3 2 5 4
     * 1 2 4 3 5
     * 2 1 3 4 5
     * 2 1 3 5 4
     * 2 1 4 3 5
     *
     * dp[i] = dp[i - 1] + dp[i - 2]
     *
     * 1 2 3 4 5
     * 3이 고정
     * 1 2 _ 4 5
     * dp[2] * dp[2]
     */
}
