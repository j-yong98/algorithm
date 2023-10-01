package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final char WALL = 'T';
    int R, C, K;
    char[][] arr;
    boolean[][] visited;
    int cnt = 0;

    /**
     * 컴백 홈
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++)
            arr[i] = br.readLine().toCharArray();
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(cnt);
        br.close();
    }

    private void dfs(int y, int x, int c) {
        if (c > K) return;
        if (y == 0 && x == C - 1) {
            if (c == K)
                cnt += 1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx) || visited[yy][xx] || arr[yy][xx] == WALL) continue;
            visited[yy][xx] = true;
            dfs(yy, xx, c + 1);
            visited[yy][xx] = false;
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
