package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem96 {
    final int MIN = -5000;
    int n;
    int[] arr;
    int[] dp;

    /**
     * 연속된 최대 부분 합 구하기
     * 이전 값 + 현재 값과 현재 값을 비교해 더 큰 값을 현재 최고 부분 합으로 계산한다.
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = MIN;
        }
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }
        int res = Arrays.stream(dp).max().getAsInt();
        System.out.println(res);
        return res;
    }
}
