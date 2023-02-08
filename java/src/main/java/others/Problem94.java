package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem94 {
    int n;
    int s;
    int[] arr;
    int[][] dp;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s += arr[i];
        }
        dp = new int[n + 1][s + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                if (j >= arr[i] && dp[i - 1][j - arr[i]] == 1)
                    dp[i][j] = 1;
                if (dp[i - 1][j] == 1)
                    dp[i][j] = 1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s; i++) {
            if (dp[n][i] == 1)
                res = Math.min(res, Math.abs(i - (s - i)));
        }
        System.out.println(res == 0 ? "Yes" : "No");
        return res;
    }
}
