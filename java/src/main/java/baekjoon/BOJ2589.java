package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ2589 {
    final char WATER = 'W';
    final int[] dy = {1, -1, 0, 0};
    final int[] dx = {0, 0, 1, -1};
    int r, c;
    char[][] arr;
    int ans = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++)
                arr[i][j] = str.charAt(j);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != WATER) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];

        q.add(new int[]{y, x, 0});
        visited[y][x] = true;
        int res = 0;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            res = Math.max(res, pos[2]);
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] != WATER) {
                    q.add(new int[]{yy, xx, pos[2] + 1});
                    visited[yy][xx] = true;
                }
            }
        }
        return res;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}
