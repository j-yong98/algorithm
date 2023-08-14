package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20164 {
    int N, L;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    /**
     * 홀수 홀릭 호석
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = getLen(N);
        f(toArr(N, L), L, 0);
        System.out.println(min + " " + max);
    }

    private void f(int[] tmp, int len, int cnt) {
        int odd = 0;
        for (int i = 0; i < len; i++) {
            if (tmp[i] % 2 == 1) odd++;
        }

        if (len == 1) {
            max = Math.max(max, cnt + odd);
            min = Math.min(min, cnt + odd);
            return;
        }
        if (len == 2) {
            int a = tmp[0] + tmp[1];
            int l = getLen(a);
            f(toArr(a, l), l, cnt + odd);
            return;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                int a = 0;
                int t = len - i - j;
                if (t <= 0) continue;
                a += makeNum(tmp, 0, i);
                a += makeNum(tmp, i, i + j);
                a += makeNum(tmp, i + j, len);
                int l = getLen(a);
                f(toArr(a, l), l, cnt + odd);
            }
        }

    }

    private int makeNum(int[] tmp, int s, int e) {
        int res = 0;
        while (s < e)
            res = (res * 10) + tmp[s++];
        return res;
    }

    private int getLen(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            n /= 10;
        }
        return len;
    }

    private int[] toArr(int n, int len) {
        int[] arr = new int[len];
        while (len-- > 0) {
            arr[len] = n % 10;
            n /= 10;
        }
        return arr;
    }
}
