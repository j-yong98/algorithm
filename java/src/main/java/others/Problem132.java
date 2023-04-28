package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem132 {
    int T;
    /**
     * 원안의 점
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = -n; i <= n; i++) {
                for (int j = -n; j <= n; j++) {
                    if (i * i + j * j <= n * n)
                        cnt++;
                }
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
