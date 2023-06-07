package baekjoon;

import java.io.*;

public class BOJ2133 {
    int n;
    int[] arr = new int[31];
    int[] dp = new int[31];
    /**
     * 타일 채우기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i+= 2) {
            arr[i] = arr[i - 2] + dp[i - 4];
            dp[i] = dp[i - 2] * 3 + arr[i] * 2;
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
