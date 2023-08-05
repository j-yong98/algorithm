package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2138 {
    int N;
    int[] init;
    int[] ans;
    int cnt;
    int res = -1;

    /**
     * 전구와 스위치
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init = new int[N];
        ans = new int[N];
        String line = br.readLine();
        for (int i = 0; i < N; i++)
            init[i] = line.charAt(i) - '0';
        line = br.readLine();
        for (int i = 0; i < N; i++)
            ans[i] = line.charAt(i) - '0';

        cnt = 0;
        if (switchChange(copyArr(init)))
            res = cnt;

        cnt = 1;
        push(0, init);
        if (switchChange(init))
            res = res != -1 ? Math.min(res, cnt) : cnt;

        System.out.println(res);
    }

    private boolean switchChange(int[] arr) {
        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != ans[i - 1]) {
                push(i, arr);
                cnt++;
            }
        }

        for (int i = 0; i < N; i++)
            if (arr[i] != ans[i]) return false;
        return true;
    }

    private int[] copyArr(int[] src) {
        int[] tmp = new int[N];
        for (int i = 0; i < N; i++)
            tmp[i] = src[i];
        return tmp;
    }

    private void push(int num, int[] arr) {
        for (int i = num - 1; i <= num + 1; i++) {
            if (i < 0 || i >= N) continue;
            arr[i] ^= 1;
        }
    }
}
