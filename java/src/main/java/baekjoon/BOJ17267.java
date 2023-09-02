package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ17267 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int WALL = 1;
    int N, M;
    int L, R;
    int[] pos = new int[2];
    int[][] arr;
    int ans = 1;

    /**
     * 상남자
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        bfs();
        System.out.println(ans);
        br.close();
    }

    private void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new int[]{pos[0], pos[1], L, R});
        visited[pos[0]][pos[1]] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();

            for (int i = 0; i < 2; i++) {
                int y = info[0], x = info[1];
                while (true) {
                    y = y + dy[i];
                    if (!inRange(y, x) || arr[y][x] == WALL) break;
                    if (visited[y][x]) continue;
                    visited[y][x] = true;
                    q.add(new int[]{y, x, info[2], info[3]});
                    ans++;
                }
            }
            for (int i = 2; i < 4; i++) {
                int y = info[0], x = info[1] + dx[i];
                if (i == 2 && info[2] == 0) continue;
                if (i == 3 && info[3] == 0) continue;
                if (!inRange(y, x) || visited[y][x] || arr[y][x] == WALL) continue;
                visited[y][x] = true;
                if (i == 2)
                    q.add(new int[]{y, x, info[2] - 1, info[3]});
                else
                    q.add(new int[]{y, x, info[2], info[3] - 1});
                ans++;
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
