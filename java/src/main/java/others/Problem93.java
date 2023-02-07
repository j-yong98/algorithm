package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem93 {
    int n;
    int s;
    int[] arr;
    int[][] dp;

    /**
     * i번 째 수까지만 고려했을 때
     * 고른 수의 합을 j로 만드는 것이 가능하면 1
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s += arr[i];
        }
        dp = new int[n + 1][s + 1];
        // 지금까지 선택한 수의 합이 0이므로 dp[0][0] = 1
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                /**
                 * 1.
                 * i번 수를 선택한 합이 j가 되는 경우
                 * i번째 수를 포함 했을 때 j 가 되어야 하기 떄문에
                 * i - 1번째에 j - arr[i]가 되면 된다.
                 * 2.
                 * i번째 수를 선택하지 않고 j가 되는 경우
                 */
                if (j >= arr[i] && dp[i - 1][j - arr[i]] == 1)
                    dp[i][j] = 1;
                if (dp[i - 1][j] == 1)
                    dp[i][j] = 1;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < s; i++) {
            if (dp[n][i] == 1)
                ans = Math.min(ans, Math.abs(i - (s - i)));
        }
        System.out.println(ans);
        return ans;
    }
}
