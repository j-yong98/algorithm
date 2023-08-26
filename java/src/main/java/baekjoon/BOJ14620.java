package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14620 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int N;
    int[][] arr;
    int ans = Integer.MAX_VALUE;
    boolean[][] visited;

    /**
     * 꽃길
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        getMinCost(0, 0);
        System.out.println(ans);
        br.close();
    }

    private void getMinCost(int n, int sum) {
        if (sum > ans) return;
        if (n == 3) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (!check(i, j)) continue;
                int cost = getCost(i, j, true);
                getMinCost(n + 1, sum + cost);
                getCost(i, j, false);
            }
        }
    }

    private boolean check(int y, int x) {
        if (visited[y][x]) return false;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (visited[yy][xx]) return false;
        }
        return true;
    }

    private int getCost(int y, int x, boolean val) {
        int cost = arr[y][x];
        visited[y][x] = val;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            cost += arr[yy][xx];
            visited[yy][xx] = val;
        }
        return cost;
    }
}
