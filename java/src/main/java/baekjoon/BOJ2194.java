package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2194 {
    final int WALL = 1;
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, -1, 1};
    int N, M;
    int A, B;
    int K;
    int[][] arr;
    int[] start = new int[2];
    int[] end = new int[2];

    /**
     * 유닛 이동 시키기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = WALL;
        }
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y + A - 1 <= N && x >= 1 && x + B - 1 <= M;
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][M + 1];

        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            if (pos[0] == end[0] && pos[1] == end[1])
                return pos[2];

            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + DY[i];
                int xx = pos[1] + DX[i];
                if (inRange(yy, xx) && checkWall(yy, xx) && !visited[yy][xx]) {
                    q.add(new int[]{yy, xx, pos[2] + 1});
                    visited[yy][xx] = true;
                }
            }
        }
        return -1;
    }

    private boolean checkWall(int y, int x) {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (arr[y + i][x + j] == WALL) return false;
            }
        }
        return true;
    }
}
