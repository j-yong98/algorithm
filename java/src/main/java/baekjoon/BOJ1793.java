package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1793 {
    static BigInteger[] dp = new BigInteger[251];
    /**
     * 타일링
     */
    public void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for (int i = 3; i <= 250; i++) {
            dp[i] = dp[i - 2].multiply(new BigInteger("2"));
            dp[i] = dp[i].add(dp[i - 1]);
        }
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
