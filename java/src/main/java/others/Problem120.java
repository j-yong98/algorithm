package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem120 {
    int T;
    /**
     * 팔씨름
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] res = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 0; i < res.length; i++) {
                if (res[i] == 'x')
                    cnt++;
            }
            if (cnt < 8)
                bw.write("#" + t + " " + "YES\n");
            else
                bw.write("#" + t + " " + "NO\n");
        }
        bw.flush();
        bw.close();
    }
}
