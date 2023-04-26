package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem127 {
    int T;
    /**
     * 프리셀 통계
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            bw.write("#" + t + " ");
            if ((d != 100 && g == 100) || (d != 0 && g == 0))
                bw.write("Broken\n");
            else {
                boolean flag = false;
                for (long i = 1; i <= n; i++) {
                    if ((i * d) % 100 == 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    bw.write("Possible\n");
                else    bw.write("Broken\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
