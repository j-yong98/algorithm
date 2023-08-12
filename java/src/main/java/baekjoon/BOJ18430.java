package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18430 {
    final int[][] DY = {{0, 1},{0,-1},{0,-1},{0,1}};
    final int[][] DX = {{-1,0},{-1,0},{1,0},{1,0}};
    int N, M;
    int[][] arr;
    int ans = 0;
    boolean[][] visited;
    int limit;

    /**
     * 무기 공학
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        limit = (int) Math.round(N * M / 4);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0, 0, 0);
        System.out.println(ans);
    }

    private void backTracking(int y, int x, int sum) {
        if (x == M) {
            x = 0;
            y += 1;
        }
        if (y == N) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int k = 0; k < 4; k++) {
            if (!visited[y][x] && canMake(y, x, k)) {
                int s = check(y, x, k, true);
                backTracking(y, x + 1, sum + s);
                check(y, x, k, false);
            }
        }
        backTracking(y, x + 1, sum);
    }

    private boolean canMake(int y, int x, int num) {
        int[] shapeY = DY[num];
        int[] shapeX = DX[num];

        for (int i = 0; i < shapeY.length; i++) {
            int yy = y + shapeY[i];
            int xx = x + shapeX[i];
            if (!inRange(yy, xx) || visited[yy][xx]) return false;
        }
        return true;
    }

    private int check(int y, int x, int num, boolean val) {
        int[] shapeY = DY[num];
        int[] shapeX = DX[num];

        int s = arr[y][x] * 2;
        visited[y][x] = val;
        for (int i = 0; i < shapeY.length; i++) {
            int yy = y + shapeY[i];
            int xx = x + shapeX[i];
            s += arr[yy][xx];
            visited[yy][xx] = val;
        }
        return s;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
