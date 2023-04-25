package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem126 {
    int T;
    /**
     * 패턴 길이 마디
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            for (int i = 0; i < 10; i++) {
                String a = s.substring(0, i);
                String b = s.substring(i, i * 2);
                if (i != 0 && a.equals(b)) {
                    bw.write("#" + t + " " + a.length() + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
