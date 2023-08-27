package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9944 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, 1, -1};
    final char WALL = '*';
    int N, M;
    char[][] arr;
    boolean[][] visited;
    int moveArea;
    int ans;
    /**
     * NxM 보드 완주하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; ; t++) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            visited = new boolean[N][M];
            ans = Integer.MAX_VALUE;
            moveArea = 0;
            for (int i = 0; i < N; i++)
                arr[i] = br.readLine().toCharArray();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != WALL) moveArea++;
                }
            }
            if (moveArea == 1) {
                sb.append("Case ").append(t).append(": ").append(0).append("\n");
                continue;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == WALL) continue;
                    for (int d = 0; d < 4; d++) {
                        visited[i][j] = true;
                        backTracking(i, j, d, 1, 1);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("Case ").append(t).append(": ").append(ans == Integer.MAX_VALUE ? -1 : ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void backTracking(int y, int x, int dir, int moveCnt, int turnCnt) {
        if (ans < turnCnt) return;
        if (moveCnt == moveArea) {
            ans = Math.min(ans, turnCnt);
            return;
        }
        int yy = y + dy[dir];
        int xx = x + dx[dir];
        if (isValid(yy, xx)) {
            visited[yy][xx] = true;
            backTracking(yy, xx, dir, moveCnt + 1, turnCnt);
            visited[yy][xx] = false;
        } else {
            for (int i = 0; i < 4; i++) {
                if (dir == i) continue;
                yy = y + dy[i];
                xx = x + dx[i];
                if (!isValid(yy, xx)) continue;
                visited[yy][xx] = true;
                backTracking(yy, xx, i, moveCnt + 1, turnCnt + 1);
                visited[yy][xx] = false;
            }
        }
    }

    private boolean isValid(int y, int x) {
        return inRange(y, x) && !visited[y][x] && arr[y][x] != WALL;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
