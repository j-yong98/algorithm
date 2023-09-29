package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger; // BigInteger를 임포트합니다.

public class BOJ4375 {

    /**
     * 1
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            BigInteger N = new BigInteger(str); // BigInteger로 N을 변환합니다.
            BigInteger tmp = BigInteger.ONE; // BigInteger로 tmp를 초기화합니다.
            int len = 1;
            while (!tmp.mod(N).equals(BigInteger.ZERO)) { // BigInteger의 mod와 equals 메소드 사용
                tmp = tmp.multiply(BigInteger.TEN).add(BigInteger.ONE); // BigInteger로 연산 수행
                len++;
            }
            sb.append(len).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}