package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem117 {
    int T;
    /**
     * 숫자가 같은 배수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] num = br.readLine().toCharArray();
            String res = make(num) == false ? "impossible\n" : "possible\n";
            bw.write("#" + t + " " + res);
        }
        bw.flush();
        bw.close();
    }
    private boolean make(char[] num) {
        int n = 0;
        for (int i = 0; i < num.length; i++) {
            n = n * 10 + ((int)num[i] - 48);
        }
        int k = 2;
        while (true) {
            int mul = k * n;
            int len = getLength(mul);
            if (num.length != len)
                break;
            if (possible(num, toChar(mul, len), len))
                return true;
            k++;
        }
        return false;
    }
    private int getLength(int num) {
        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        return len;
    }
    private char[] toChar(int num, int len) {
        char[] tmp = new char[len];
        int idx = len - 1;
        while (num >  0) {
            tmp[idx] = (char)(num % 10 + 48);
            idx--;
            num /= 10;
        }
        return tmp;
    }
    private boolean possible(char[] num, char[] mul, int len) {
        boolean[] checked = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (num[j] == mul[i] && !checked[j]) {
                    checked[j] = true;
                    break ;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (!checked[i])
                return false;
        }
        return true;
    }
}
