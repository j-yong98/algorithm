package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ21312 {
    final int MAX = 3;
    int ans = 0;
    int[] arr;

    /**
     * 홀짝 칵테일
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < MAX; i++)
            comb(0, arr[i], i);
        System.out.println(ans);
    }

    private void comb(int l, int sum, int start) {
        if (l == MAX) {
            int a = ans % 2;
            int b = sum % 2;
            if (a < b)
                ans = sum;
            else if (a == b)
                ans = Math.max(ans, sum);
            return;
        }

        comb(l + 1, sum, start);
        if (start == l) return;
        comb(l + 1, sum * arr[l], start);
    }
}
