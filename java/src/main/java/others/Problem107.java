package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem107 {
    int T;
    long n;
    /**
     * 구구단 걷기
     * 10
     * 1,10 2 5 5 2 10 1
     *
     * 50
     * 1 50, 2 25, 5 10, 10 5,
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Long.parseLong(br.readLine());
            long dist = n - 1;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    dist = Math.min(dist, i + (n / i) - 2);
            }
            System.out.println("#" + t + " " + dist);
        }
    }
}
