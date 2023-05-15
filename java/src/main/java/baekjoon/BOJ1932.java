package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1932 {
    int n;
    int[][] arr;
    int[][] dp;
    /**
     * 정수 삼각형
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
            dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++)
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
        }
        int max = Arrays.stream(dp[n - 1]).max().getAsInt();
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
