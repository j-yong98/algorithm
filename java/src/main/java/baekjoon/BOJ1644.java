package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1644 {
    final int MAX = 5_000_000;
    int N;
    boolean[] prime = new boolean[MAX + 1];

    /**
     * 소수의 연속
     * 에라스토테네스의 체로 소수를 구해 놓고
     * 투 포인터 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        N = Integer.parseInt(br.readLine());
        int l = 0, r = 0;
        l = findPrime(0);
        r = findPrime(l + 1);
        int sum = l;
        int ans = 0;
        while (l <= N) {
            while (sum < N) {
                sum += r;
                r = findPrime(r + 1);
            }
            if (sum == N) {
                ans++;
                sum += r;
                r = findPrime(r + 1);
            }
            while (sum > N) {
                sum -= l;
                l = findPrime(l + 1);
            }
            if (sum == N) {
                ans++;
                sum -= l;
                l = findPrime(l + 1);
            }
        }
        System.out.println(ans);
    }

    private int findPrime(int idx) {
        while (true) {
            if (!prime[idx]) return idx;
            idx++;
        }
    }

    private void init() {
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(MAX); i++) {
            if (prime[i]) continue;
            for (int j = i + i; j <= MAX; j += i)
                prime[j] = true;
        }
    }
}
