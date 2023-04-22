package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem118 {
    int T;
    /**
     * 1차원 정원
     * 5 1
     * 1 2 3    4 5
     * 5 2
     * 1 2 3 4 5
     * 5 2
     * 100 3
     * 1 2 3 4 5 6 7    8 9 10 11 12 13 14    15 16 17 18 19 20 21
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int cnt = n / (2 * d + 1);
            if (n % (2 * d + 1) > 0)
                cnt++;
            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
