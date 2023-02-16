package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1915 {
    int n, m;
    int[][] arr;
    int[][] dp;

    private void printdp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 1)
                dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (arr[0][i] == 1)
                dp[0][i] = 1;
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.digit(chars[j],10);
            }
        }
        init();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    int min = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                    dp[i][j] = Math.max(dp[i][j], min + 1);
                }
            }
        }
        System.out.println((int)Math.pow(Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt(),2));
    }

}
