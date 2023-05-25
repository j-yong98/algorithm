package baekjoon;

import java.io.*;

public class BOJ15988 {
    final int DIV = 1_000_000_009;
    final int MAX = 1_000_000;
    int T;
    int n;
    long[] dp = new long[MAX + 1];
    /**
     * 1, 2, 3 더하기 3
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            bw.write(topDown(n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private long topDown(int num) {
        if (dp[num] != 0)
            return dp[num];
        dp[num] = (topDown(num - 1) + topDown(num - 2) + topDown(num - 3)) % DIV;
        return dp[num];
    }
}
