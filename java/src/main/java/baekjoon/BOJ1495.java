package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1495 {
    int n, s, m;
    int[] arr;
    boolean[][] dp = new boolean[51][1001];
    /**
     * 기타리스트
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    if (j + arr[i] <= m)
                        dp[i][j + arr[i]] = true;
                    if (j - arr[i] >= 0)
                        dp[i][j - arr[i]] = true;
                }
            }
        }
        int ans = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                ans = i;
                break ;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
