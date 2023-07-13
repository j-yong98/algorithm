package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ14940 {
    final int CAN = 1;
    final int GOAL = 2;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int n, m;
    int[][] arr;
    int[] start = new int[2];
    StringBuilder sb = new StringBuilder();
    /**
     * 쉬운 최단 거리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == GOAL) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        bfs();
        br.close();
    }

    private void bfs() {
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        visited[start[0]][start[1]] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] == CAN) {
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                    visited[y][x] = true;
                    q.add(new int[]{y, x});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == CAN)
                    sb.append(-1).append(" ");
                else
                    sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
