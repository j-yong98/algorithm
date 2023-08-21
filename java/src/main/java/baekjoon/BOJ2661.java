package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2661 {
    int N;
    StringBuilder sb = new StringBuilder();

    /**
     * 좋은 수열
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        makeNum(0);
    }

    private void makeNum(int l) {
        if (l == N) {
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }
        if (sb.length() == 0) {
            for (int i = 1; i <= 3; i++) {
                sb.append(i);
                makeNum(l + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            int pre = sb.charAt(l - 1) - '0';
            for (int i = 1; i <= 3; i++) {
                if (i == pre) continue;
                if (check(sb.toString() + i)) {
                    sb.append(i);
                    makeNum(l + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    private boolean check(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j <= str.length() / 2; j++) {
                if (i + j > str.length() || i + j + j > str.length()) break;
                String sub1 = str.substring(i, i + j);
                String sub2 = str.substring(i + j, i + j + j);
                if (sub1.equals(sub2)) return false;
            }
        }
        return true;
    }
}
