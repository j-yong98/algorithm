package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20542 {
    int N, M;
    String a, b;
    int[][] dp;
    /**
     * 받아 쓰기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = '0' + br.readLine();
        b = '0' + br.readLine();
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            dp[i][0] = i;
        for (int j = 1; j <= M; j++)
            dp[0][j] = j;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                if (isEqual(a.charAt(i), b.charAt(j)))
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        System.out.println(dp[N][M]);
        br.close();
    }

    private boolean isEqual(char c1, char c2) {
        if (c1 == 'i')
            return (c2 == 'i' || c2 == 'j' || c2 == 'l') ? true : false;
        if (c1 == 'v')
            return (c2 == 'v' || c2 == 'w') ? true : false;
        return c1 == c2;
    }
}
