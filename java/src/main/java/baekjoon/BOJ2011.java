package baekjoon;

import java.io.*;

public class BOJ2011 {
    final int MOD = 1_000_000;
    int[] arr;
    int[] dp = new int[5001];
    /**
     * 암호 코드
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        arr = new int[line.length() + 1];
        for (int i = 1; i <= line.length(); i++)
            arr[i] = line.charAt(i - 1) - 48;
        if (arr[1] == 0)
            bw.write("0\n");
        else {
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= line.length(); i++) {
                if (arr[i] >= 1 && arr[i] <= 9)
                    dp[i] = dp[i - 1];
                if (arr[i - 1] == 0)
                    continue;
                int sum = 10 * arr[i - 1] + arr[i];
                if (sum >= 10 && sum <= 26)
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
            bw.write(dp[line.length()] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
