package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9465 {
    int T;
    int n;
    int[][] arr;
    int[][] dp;

    /**
     * 스티커
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            dp = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int i = 2; i <= n; i++) {
                    dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                    dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }
            bw.write(Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
