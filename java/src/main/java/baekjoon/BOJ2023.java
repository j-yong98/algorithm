package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {
    int N;
    StringBuilder sb = new StringBuilder();

    /**
     * 신기한 소수
     * 에라스토테네스의 체로 접근을 하려 했으나 메모리가 4MB이고 10^N-1~10^N까지 모든 숫자를 소수로 확인해서 출력하는 것은 시간 초과
     * 따라서 조합을 통해 수를 만들고 만든 수가 N자리가 될때까지 소수이면 출력한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        interestingPrime(new StringBuilder(), 0);
        System.out.println(sb);
    }

    private void interestingPrime(StringBuilder s, int cnt) {
        if (s.length() != 0 && !isPrime(Integer.parseInt(s.toString()))) return;
        if (cnt == N) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            s.append(i);
            interestingPrime(s, cnt + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}
