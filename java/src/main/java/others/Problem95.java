package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem95 {
    final int MAX = 10000000;
    int n;
    int m;
    int s;
    int[] exp;
    int[] time;
    int[] dp;

    private void init() {
        for (int i = 0; i <= s; i++)
        {
            dp[i] = MAX;
        }
        dp[0] = 0;
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        exp = new int[n + 1];
        time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            exp[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
            s += exp[i];
        }
        dp = new int[s + 1];
        init();
        for (int i = 1; i <= n; i++) {
            for (int j = s; j >= 0; j--) {
                if (j < exp[i]) continue;
                dp[j] = Math.min(dp[j], dp[j - exp[i]] + time[i]);
            }
        }
        int res = MAX;
        for (int i = m; i <= s; i++) {
            res = Math.min(res, dp[i]);
        }
        System.out.println(res != MAX ? res : -1);
        return res;
    }
}
