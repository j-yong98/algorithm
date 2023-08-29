package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {
    final int MOD = 1_000;
    int[][] arr;
    int A;
    long B;

    /**
     * 행렬 제곱
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[A][A];
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A; j++)
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
        }
        int[][] res = pow(arr, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++)
                sb.append(res[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int[][] pow(int[][] a, long b) {
        if (b == 1)
            return a;

        int[][] tmp = pow(a, b / 2);

        tmp = mul(tmp, tmp);
        if (b % 2 == 1)
            tmp = mul(tmp, arr);

        return tmp;
    }

    private int[][] mul(int[][] a, int[][] b) {
        int[][] tmp = new int[A][A];

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                for (int k = 0; k < A; k++) {
                    tmp[i][j] += (a[i][k] * b[k][j]);
                    tmp[i][j] %= MOD;
                }
            }
        }

        return tmp;
    }
}
