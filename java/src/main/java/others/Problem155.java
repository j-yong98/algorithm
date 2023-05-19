package others;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem155 {
    final int SIZE = 100;
    final int T = 10;
    int[] ans = new int[T + 1];

    /**
     * SUM
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < SIZE; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            ans[n] = getMaxSum(arr);
        }
        for (int i = 1; i <= T; i++)
            bw.write("#" + i + " " + ans[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int getMaxSum(int[][] arr) {
        int res = 0;
        for (int i = 0; i < SIZE; i++)
            res = Math.max(res, Arrays.stream(arr[i]).sum());
        for (int i = 0; i < SIZE; i++) {
            int sum = 0;
            for (int j = 0; j < SIZE; j++)
                sum += arr[j][i];
            res = Math.max(res, sum);
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < SIZE; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][SIZE - i - 1];
        }
        res = Math.max(res, Math.max(sum1, sum2));
        return res;
    }
}
