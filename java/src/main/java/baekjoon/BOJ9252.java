package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ9252 {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str1;
    String str2;
    int[][] dp;

    /**
     * LCS 2 
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = " " + br.readLine();
        str2 = " " + br.readLine();
        dp = new int[str1.length()][str2.length()];

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        int max = Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
        bw.write( max + "\n");
        trace(str1.length() - 1, str2.length() - 1);
        bw.flush();
        bw.close();
        br.close();
    }

    private void trace(int l1, int l2) throws IOException {
        if (dp[l1][l2] == 0)
            return;
        if (dp[l1 - 1][l2] == dp[l1][l2]) {
            trace(l1 - 1, l2);
            return;
        }
        if (dp[l1][l2 - 1] == dp[l1][l2]) {
            trace(l1, l2 - 1);
            return;
        }
        trace(l1 - 1, l2 - 1);
        bw.write(str1.charAt(l1));
    }
}
