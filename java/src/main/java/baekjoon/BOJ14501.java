package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    int n;
    int[] t;
    int[] p;
    int[] dp;

    //퇴사
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 2];
        t = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            t[i] = time;
            p[i] = pay;
        }
        for (int i = n; i > 0; i--) {
            if (t[i] + i <= n + 1)
                dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]);
            else
                dp[i] = dp[i + 1];
        }
        System.out.println(dp[1]);
    }
}
