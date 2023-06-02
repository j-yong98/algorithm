package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14002 {
    int n;
    int[] arr;
    int[] dp;
    int[] idx;
    StringBuilder sb = new StringBuilder();

    /**
     *  가장 긴 증가하는 부분 수열 4
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        idx = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            idx[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        idx[i] = j;
                    }
                }
            }
        }
        int ans = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                end = i;
            }
        }
        sb.append(ans).append("\n");
        showPath(end);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void showPath(int end) {
        if (end == idx[end]) {
            sb.append(arr[end]).append(" ");
            return;
        }
        showPath(idx[end]);
        sb.append(arr[end]).append(" ");
    }
}
