package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ10476 {
    int n, k;
    int[][] arr = new int[205][2];
    int[][][] dp = new int[205][205][3];

    /**
     * 좁은 미술전시관
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        for (int i = 1; i <= n; i++) {
            line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }
        dp[1][1][0] = arr[1][1];
        dp[1][1][1] = arr[1][0];
        dp[1][0][2] = arr[1][0] + arr[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= 1) {
                    dp[i][j][0] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][2]) + arr[i][1];
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][0];
                }
                if (j != i)
                    dp[i][j][2] = Math.max(Math.max(dp[i - 1][j][0], dp[i - 1][j][1]), dp[i - 1][j][2]) + (arr[i][0] + arr[i][1]);
            }
        }
        bw.write(Arrays.stream(dp[n][k]).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
