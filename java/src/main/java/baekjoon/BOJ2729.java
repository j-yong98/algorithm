package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2729 {
    int N;

    /**
     * 이진수 덧셈
     * 캐리 수로 자리수 증가 경우 조심 + 앞에 0 지울 때 답이 0 인 경우 조심
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            System.out.println(add(a, b));
        }
        br.close();
    }

    private String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int min = Math.min(a.length(), b.length());
        int idx1 = a.length() - 1;
        int idx2 = b.length() - 1;
        for (int i = 0; i < min; i++) {
            int tmp1 = a.charAt(idx1--) - '0';
            int tmp2 = b.charAt(idx2--) - '0';
            sb.insert(0, (tmp1 + tmp2 + carry) % 2);
            carry = (tmp1 + tmp2 + carry) / 2;
        }
        while (idx1 >= 0) {
            int tmp = a.charAt(idx1--) - '0';
            sb.insert(0, (tmp + carry) % 2);
            carry = (tmp + carry) / 2;
        }
        while (idx2 >= 0) {
            int tmp = b.charAt(idx2--) - '0';
            sb.insert(0, (tmp + carry) % 2);
            carry = (tmp + carry) / 2;
        }
        if (idx1 == -1 && idx2 == -1 && carry == 1)
            sb.insert(0, 1);
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
