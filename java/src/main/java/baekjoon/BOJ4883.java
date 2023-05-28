package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4883 {
    final int MAX = 1_000_000_000;

    int n;
    int[][] arr;
    int[][] dp;

    /**
     * 삼각 그래프
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; ; t++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            arr = new int[n][3];
            dp = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++)
                    dp[i][j] = arr[i][j];
            }
            dp[0][0] = MAX;
            dp[0][2] += dp[0][1];
            for (int i = 1; i < n; i++) {
                dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] += Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));
                dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
            }
            bw.write(t + ". " + dp[n - 1][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
