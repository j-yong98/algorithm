package baekjoon;

import java.io.*;

public class BOJ14246 {
    int n, k;
    int[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        k = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int e = i;
            int sum = 0;
            while (e < n) {
                sum += arr[e];
                if (sum > k) {
                    ans += n - e;
                    break;
                }
                e++;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
