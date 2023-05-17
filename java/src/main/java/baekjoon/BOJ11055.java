package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ11055 {
    int n;
    int[] arr;
    int[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
            }
        }
        int ans = Arrays.stream(dp).max().getAsInt();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
