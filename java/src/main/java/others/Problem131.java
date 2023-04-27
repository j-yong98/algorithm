package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem131 {
    int T;
    int[] arr;
    /**
     * 평범한 숫자
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = 1; i < n - 1; i++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int j = i - 1; j <= i + 1; j++) {
                    if (max < arr[j])
                        max = arr[j];
                    if (min > arr[j])
                        min = arr[j];
                }
                if (max != arr[i] && min != arr[i])
                    cnt++;
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
