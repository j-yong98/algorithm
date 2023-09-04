package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5904 {
    int N;
    String str = "moo";

    /**
     * Moo 게임
     * 분할 정복 문제
     * 문자의 길이가 2*S(K - 1) + k + 3의 길이로 늘어난다.
     * 찾고자 하는 문자의 위치가 해당 문자 길이에 포함이 된다면 탐색을 하게 된다.
     * 추가 되는 문자의 길이는 S(K - 1) + (k + 1) + 3의 길이가 추가 되게 된다.
     * 이 범위 뒤인 S(K - 1)의 길이에서는 다시 탐색을 시작한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        moo(N, 0,str.length());
        br.close();
    }

    private void moo(int n, int k, int len) {
        if (n <= 3) {
            System.out.println(str.charAt(n - 1));
            return;
        }
        if (len * 2 + (k + 1 + 3) < n) {
            moo(n, k + 1, len * 2 + (k + 1 + 3));
        } else {
            if (n > len) {
                if (n - len <= k + 1 + 3) {
                    if (n - len == 1) {
                        System.out.println("m");
                        return;
                    } else {
                        System.out.println("o");
                        return;
                    }
                }
                else {
                    moo(n - (len + k + 1 + 3), 0, str.length());
                }
            }
        }
    }
}
