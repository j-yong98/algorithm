package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626 {
    int N;
    int[] dp;

    /**
     * Four Square
     * 2 ~ N까지 최소 제곱 수를 만들면서 배열에 저장 후 이미 저장 된 값을 이용해서 연산 횟수를 줄인다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++)
                min = Math.min(min, dp[i - j * j]);
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}
