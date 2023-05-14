package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                b[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(a);
            Arrays.sort(b);

            int cnt = 0;
            int p = 0;
            for (int i = 0; i < n; i++) {
                while (p < m && a[i] > b[p])
                    p++;
                cnt += p;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
