package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem111 {
    int T;
    private String isT(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int d = 0;
        for (int i = 1; i <= sLen && i <= tLen; i++) {
            if (sLen % i == 0 && tLen % i == 0)
                d = i;
        }
        String tmp1 = "";
        String tmp2 = "";
        int m = sLen * tLen / d;
        for (int i = 0; i < m / sLen; i++) {
            tmp1 += s;
        }
        for (int i = 0; i < m / tLen; i++) {
            tmp2 += t;
        }
        if (tmp1.equals(tmp2))
            return "yes";
        return "no";
    }
    /**
     * 무한 문자열
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String f = st.nextToken();
            System.out.println("#" + t + " " + isT(s, f));
        }
    }
}
