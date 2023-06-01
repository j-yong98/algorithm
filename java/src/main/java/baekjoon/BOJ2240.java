package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2240 {
    int t, w;
    int[] arr = new int[1001];
    int[][][] dp = new int[3][1001][32];
    /**
     * 자두나무
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                }
                else {
                    if (i == 1 && j == 1)
                        continue;
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
                }
            }
        }
        int max = Math.max(Arrays.stream(dp[1]).flatMapToInt(Arrays::stream).max().getAsInt(), Arrays.stream(dp[2]).flatMapToInt(Arrays::stream).max().getAsInt());
        bw.write( max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
