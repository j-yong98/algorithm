package baekjoon;

import java.io.*;

public class BOJ11052 {
    int n;
    int[] arr;
    int[] dp;
    /**
     * 카드 구매하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(line[i - 1]);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
