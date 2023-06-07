package others;

import java.io.*;
import java.util.Arrays;

public class Problem159 {
    int n;
    int[] arr;
    int[] dp;
    /**
     * 연속 부분 합의 최댓값 구하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        dp[0] = arr[0];
        for (int i = 1; i < n; i++)
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        bw.write(Arrays.stream(dp).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
