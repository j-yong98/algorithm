package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11401 {
    final int MOD = 1_000_000_007;
    int N, K;

    /**
     * 이항 계수 3
     * n C k 는 (n - 1 C k - 1) + (n - 1 C k)로 표현이 가능하고
     * 해당 표현을 페르마의 소정리를 이용해 변형 후 분할 정복 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long num = factorial(N);
        long denominator = (factorial(K) * factorial(N - K)) % MOD;
        long ans = (num * pow(denominator, MOD - 2)) % MOD;
        System.out.println(ans);
        br.close();
    }

    private long pow(long n, int k) {
        if (k == 1) return n % MOD;

        long tmp = pow(n, k / 2);

        if (k % 2 == 1)
            return (tmp * tmp % MOD) * n % MOD;
        return (tmp * tmp) % MOD;
    }

    private long factorial(int n) {
        long res = 1;
        while (n > 0) {
            res = (res * n) % MOD;
            n--;
        }
        return res;
    }
}
