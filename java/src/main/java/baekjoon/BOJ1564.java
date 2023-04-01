package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1564 {
    long n;
    long res = 1;
    /**
     * 팩토리얼5
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            res *= i;
            while (res % 10 == 0)
                res /= 10;
            res %= (long)1e12;
        }
        System.out.printf("%05d", (res % 100000));
    }
}
