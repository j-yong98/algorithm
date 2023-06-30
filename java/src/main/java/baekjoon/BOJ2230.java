package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ2230 {
    int n, m;
    int[] arr;
    /**
     * 수 고르기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] - arr[i] < m)
                j++;
            if (j == n)
                break;
            ans = Math.min(ans, arr[j] - arr[i]);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
