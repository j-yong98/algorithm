package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem150 {
    int T;
    /**
     * 이진수 표현
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean flag = true;
            while (n-- > 0) {
                if (m % 2 == 0) {
                    flag = false;
                    break ;
                }
                m /= 2;
            }
            bw.write("#" + t + " ");
            if (flag)
                bw.write("ON\n");
            else
                bw.write("OFF\n");
        }
        bw.flush();
        bw.close();
    }
}
