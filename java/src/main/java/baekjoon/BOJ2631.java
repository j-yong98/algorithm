package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ2631 {
    int n;
    int[] arr;
    int[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        bw.write((n - max) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
