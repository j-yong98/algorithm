package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ14923 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int BLANK = 0;
    final int WALL = 1;
    final int MAX = 100_000_000;
    int N, M;
    int[] start = new int[2];
    int[] end = new int[2];
    int[][] arr;

    /**
     * 미로 탈출
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int res = bfs();
        System.out.println(res == MAX ? -1 : res);
        br.close();
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        int[][][] dist = new int[2][N + 1][M + 1];

        for (int k = 0; k < 2; k++)
            for (int i = 1; i <= N; i++)
                Arrays.fill(dist[k][i], MAX);

        q.add(new int[]{start[0], start[1], 1});
        dist[0][start[0]][start[1]] = 0;
        dist[1][start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x)) continue;
                if (arr[y][x] == BLANK && dist[pos[2]][y][x] > dist[pos[2]][pos[0]][pos[1]] + 1) {
                    dist[pos[2]][y][x] = dist[pos[2]][pos[0]][pos[1]] + 1;
                    q.add(new int[]{y, x, pos[2]});
                } else if (arr[y][x] == WALL && pos[2] == 1) {
                    dist[0][y][x] = dist[pos[2]][pos[0]][pos[1]] + 1;
                    q.add(new int[]{y, x, 0});
                }
            }
        }

        return Math.min(dist[0][end[0]][end[1]], dist[1][end[0]][end[1]]);
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= M;
    }
}
