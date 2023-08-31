package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1103 {
    final int MAX = 1_000_000;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final char HOLE = 'H';
    int N, M;
    boolean[][] visited;
    char[][] arr;
    int[][] dp;
    int ans = 0;
    boolean flag = false;

    /**
     * 게임
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();
        simulate(0, 0, 0);
        if (flag)
            ans = -1;
        System.out.println(dp[0][0] > MAX ? -1 : dp[0][0]);
        br.close();
    }

    private int simulate(int y, int x, int cnt) {
        if (flag) return dp[y][x];
        if (visited[y][x]) return MAX;
        if (dp[y][x] != -1) return dp[y][x];

        visited[y][x] = true;
        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i] * (arr[y][x] - '0');
            int xx = x + dx[i] * (arr[y][x] - '0');
            if (!inRange(yy, xx) || arr[yy][xx] == HOLE) {
                dp[y][x] = Math.max(dp[y][x], 1);
                continue;
            }
            dp[y][x] = Math.max(dp[y][x], simulate(yy, xx, cnt + 1) + 1);
            if (dp[y][x] > MAX) {
                flag = true;
                return MAX;
            }
        }
        visited[y][x] = false;

        return dp[y][x];
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
