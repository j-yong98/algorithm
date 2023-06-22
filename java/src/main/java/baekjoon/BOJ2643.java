package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ2643 {
    int n;
    int[][] arr;
    int[] dp;
    /**
     * 색종이 올려 놓기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][2];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            arr[i][0] = Math.min(r, c);
            arr[i][1] = Math.max(r, c);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i][0] >= arr[j][0] && arr[i][1] >= arr[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        bw.write(Arrays.stream(dp).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
