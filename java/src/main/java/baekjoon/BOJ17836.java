package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ17836 {
    final int WALL = 1;
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, -1, 1};
    final int MAX = 10_000_000;
    int N, M, T;
    int[][] arr;

    /**
     * 공주님을 구해라
     * bfs탐색 중 검을 주우면 주운 상태로 벽을 부수면서 감
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = bfs();
        System.out.println(ans > T ? "Fail" : ans);
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[2][N][M];

        visited[0][0][0] = true;
        q.add(new int[]{0, 0, 0, 0});

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == N - 1 && now[1] == M - 1)
                return now[2];
            for (int i = 0; i < 4; i++) {
                int y = now[0] + DY[i];
                int x = now[1] + DX[i];
                if (!inRange(y, x)) continue;
                if (now[3] == 0) {
                    if (!visited[now[3]][y][x] && arr[y][x] != WALL) {
                        visited[now[3]][y][x] = true;
                        if (arr[y][x] == 2)
                            q.add(new int[]{y, x, now[2] + 1, 1});
                        else
                            q.add(new int[]{y, x, now[2] + 1, now[3]});
                    }
                } else {
                    if (!visited[now[3]][y][x]) {
                        visited[now[3]][y][x] = true;
                        q.add(new int[]{y, x, now[2] + 1, now[3]});
                    }
                }
            }
        }
        return MAX;
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
