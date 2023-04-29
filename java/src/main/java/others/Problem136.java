package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem136 {
    int T;
    /**
     * 문제이름
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

                if (dist <= 20) ans += 10;
                else if (dist <= 40) ans += 9;
                else if (dist <= 60) ans += 8;
                else if (dist <= 80) ans += 7;
                else if (dist <= 100) ans += 6;
                else if (dist <= 120) ans += 5;
                else if (dist <= 140) ans += 4;
                else if (dist <= 160) ans += 3;
                else if (dist <= 180) ans += 2;
                else if (dist <= 200) ans += 1;
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
