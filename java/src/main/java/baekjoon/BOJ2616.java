package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2616 {
    final int MAX = 3;
    int n, k;
    int[] arr;
    int[][] dp;

    /**
     * 소형 기관차
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dp = new int[MAX + 1][n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = arr[i - 1] + arr[i];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - k] + (arr[j] - arr[j - k]));
            }
        }
        bw.write(dp[3][n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
