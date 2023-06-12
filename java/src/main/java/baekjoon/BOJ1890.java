package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1890 {
    int n;
    int[][] arr;
    long[][] dp;

    /**
     * 점프
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        bw.write(dfs(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private long dfs(int y, int x) {
        if (!inRange(y, x))
            return 0;
        if (y == n - 1 && x == n - 1)
            return 1;
        if (dp[y][x] != 0)
            return dp[y][x];
        if (arr[y][x] < 1)
            return 0;
        dp[y][x] = dfs(y + arr[y][x], x) + dfs(y, x + arr[y][x]);
        return dp[y][x];
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
