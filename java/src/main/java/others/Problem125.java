package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem125 {
    int T;
    /**
     * 24시간제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int ans = (s + e) % 24;
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
