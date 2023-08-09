package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2096 {
    int N;
    int[][] dp;
    int[][] arr;

    /**
     * 내려가기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }
        for (int i = 0; i < 3; i++)
            dp[0][i] = arr[0][i];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int max;
                if (j == 0)
                    max = Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
                else if (j == 2)
                    max = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                else
                    max = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1]));
                dp[i][j] = max + arr[i][j];
            }
        }

        System.out.print(Arrays.stream(dp[N - 1]).max().getAsInt() + " ");
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], 0);

        for (int i = 0; i < 3; i++)
            dp[0][i] = arr[0][i];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min;
                if (j == 0)
                    min = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                else if (j == 2)
                    min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                else
                    min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                dp[i][j] = min + arr[i][j];
            }
        }
        System.out.println(Arrays.stream(dp[N - 1]).min().getAsInt());
    }
}
