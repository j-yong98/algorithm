package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    final int MAX = 10_000;
    int n;
    int[] arr;
    int[] dp = new int[MAX + 1];

    /**
     * 포도주 시식
     * 연속해서 3개의 음료를 마시지 못한다.
     * 현재의 포도 주의 양 + 현재 - 2까지의 계산한 최대 포도주의 값, 이전 까지 계산한 최대 포도주의 값, 현재 - 3의 포도 주의 최대 값 + 현재 - 1의 포도 주의 값 + 현재 - 2의 포도 주의 값
     * 중 가장 큰 값을 현재까지 포도 주의 최대값으로 취한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        dp[1] = arr[1];
        if (n >= 2)
            dp[2] = dp[1] + arr[2];
        if (n >= 3)
            dp[3] = Math.max(dp[2], Math.max(arr[2] + arr[3], arr[1] + arr[3]));
        for (int i = 4; i <= n; i++)
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        System.out.println(dp[n]);
        br.close();
    }
}
