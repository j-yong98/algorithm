package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2573 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};

    int n, m;
    int[][] arr;
    boolean[][] visited;
    int year = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            int cnt = isMelt();
            if (cnt == 0) {
                year = 0;
                break ;
            }
            if (cnt >= 2)
                break ;
            year++;
            melt();
        }
        bw.write(year + "\n");
        bw.flush();
        bw.close();
    }

    private int isMelt() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                visited[i][j] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    cnt++;
                    markLocation(i, j);
                }
            }
        }
        return cnt;
    }

    private void markLocation(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] > 0) {
                    visited[yy][xx] = true;
                    q.add(new int[]{yy, xx});
                }
            }
        }
    }

    private void melt() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int y = i + dy[d];
                        int x = j + dx[d];
                        if (inRange(y, x) && arr[y][x] == 0)
                            cnt++;
                    }
                    tmp[i][j] = arr[i][j] - cnt;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[i][j] = tmp[i][j] < 0 ? 0 : tmp[i][j];
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
