package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    final int MAX = 50000;
    int n, m;
    int[][] arr;
    int[][] dp;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    int ans;

    public boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] == MAX ? "- " : dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int dfs(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        if (y == n - 1 && x == m - 1) {
            return 1;
        }
        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx) && arr[yy][xx] < arr[y][x]) {
                dp[y][x] += dfs(yy, xx);
            }
        }
        return dp[y][x];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }
}
