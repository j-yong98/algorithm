package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ2565 {
    final int MAX = 10;
    int n;
    int[][] arr;
    int[] dp = new int[MAX + 1];
    /**
     * 전깃줄
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i][1] > arr[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        bw.write((n - Arrays.stream(dp).max().getAsInt()) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
