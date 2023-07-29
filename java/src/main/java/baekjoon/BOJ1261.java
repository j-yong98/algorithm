package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ1261 {
    final int MAX = 10_000_000;
    final int BLANK = 0;
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, -1, 1};
    int m, n;
    int[][] arr;

    /**
     * 알고스팟
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                arr[i][j] = str.charAt(j) - '0';
        }
        System.out.println(bfs());
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], MAX);

        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[0] == n - 1 && pos[1] == m - 1)
                visited[n - 1][m - 1] = Math.min(visited[n - 1][m - 1], pos[2]);
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + DY[i];
                int x = pos[1] + DX[i];
                if (inRange(y, x)) {
                    if (arr[y][x] == BLANK && visited[y][x] > pos[2]) {
                        visited[y][x] = pos[2];
                        q.add(new int[]{y, x, pos[2]});
                    } else if (arr[y][x] != BLANK && visited[y][x] > pos[2] + 1) {
                        visited[y][x] = pos[2] + 1;
                        q.add(new int[]{y, x, pos[2] + 1});
                    }
                }
            }
        }
        return visited[n - 1][m - 1];
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
