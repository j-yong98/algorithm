package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem110 {
    final int MAX = 1000000000;
    int T;
    int n;
    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    /**
     * 합성수 방정식
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= MAX; i++) {
                int j = i + n;
                if (j > MAX)
                    break ;
                if (!isPrime(i) && !isPrime(j)) {
                    System.out.println("#" + t + " " + j + " " + i);
                    break;
                }
            }
        }
    }
}
