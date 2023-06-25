package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ4179 {
    final int MAX = 10_000_000;
    final char WALL = '#';
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int r, c;
    char[][] arr;
    int[] start = new int[2];
    List<int[]> fires = new ArrayList<>();

    /**
     * 불!
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'J') {
                    start[0] = i;
                    start[1] = j;
                } else if (arr[i][j] == 'F')
                    fires.add(new int[]{i, j});
            }
        }
        int ans = bfs();
        bw.write(ans == -1 ? "IMPOSSIBLE\n" : ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs() {
        boolean[][] visited = new boolean[r][c];
        Deque<int[]> q = new ArrayDeque<>();
        int[][] f = new int[r][c];

        for (int i = 0; i < r; i++)
            Arrays.fill(f[i], MAX);

        for (int[] fire : fires) {
            f[fire[0]][fire[1]] = 0;
            q.add(new int[]{fire[0], fire[1]});
            visited[fire[0]][fire[1]] = true;
        }
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] != WALL) {
                    visited[y][x] = true;
                    f[y][x] = f[pos[0]][pos[1]] + 1;
                    q.add(new int[]{y, x});
                }
            }
        }

        for (int i = 0; i < r; i++)
            Arrays.fill(visited[i], false);
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x))
                    return pos[2] + 1;
                if (!visited[y][x] && arr[y][x] != WALL && f[y][x] > pos[2] + 1) {
                    q.add(new int[]{y, x, pos[2] + 1});
                    visited[y][x] = true;
                }
            }
        }
        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}
