package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1726 {
    final int WALL = 1;
    final int[] dy = { 0, 0, 1, -1 };
    final int[] dx = { 1, -1, 0, 0 };
    int N, M;
    int[][] arr;
    int[] start = new int[3];
    int[] end = new int[3];

    /**
     * 로봇
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken()) - 1;
        start[1] = Integer.parseInt(st.nextToken()) - 1;
        start[2] = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken()) - 1;
        end[1] = Integer.parseInt(st.nextToken()) - 1;
        end[2] = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(bfs());
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[4][N][M];
        q.add(new int[] { start[0], start[1], start[2], 0 });
        visited[start[2]][start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            if (pos[0] == end[0] && pos[1] == end[1] && pos[2] == end[2])
                return pos[3];

            int left = getLeft(pos[2]);
            int right = getRight(pos[2]);
            if (!visited[left][pos[0]][pos[1]]) {
                q.add(new int[] { pos[0], pos[1], left, pos[3] + 1 });
                visited[left][pos[0]][pos[1]] = true;
            }
            if (!visited[right][pos[0]][pos[1]]) {
                q.add(new int[] { pos[0], pos[1], right, pos[3] + 1 });
                visited[right][pos[0]][pos[1]] = true;
            }
            for (int i = 1; i <= 3; i++) {
                int y = pos[0] + dy[pos[2]] * i;
                int x = pos[1] + dx[pos[2]] * i;
                if (!inRange(y, x) || arr[y][x] == WALL) break;
                if (visited[pos[2]][y][x])
                    continue;
                visited[pos[2]][y][x] = true;
                q.add(new int[] { y, x, pos[2], pos[3] + 1 });
            }
        }
        return -1;
    }

    private int getLeft(int d) {
        if (d == 0 || d == 1)
            return d ^ 3;
        return d ^ 2;
    }

    private int getRight(int d) {
        if (d == 0 || d == 1)
            return d ^ 2;
        return d ^ 3;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
