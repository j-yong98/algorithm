package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1926 {
    int r, c;
    int[][] arr;
    boolean[][] visited;

    /**
     * 그림
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        arr = new int[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int size = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    ans++;
                    size = Math.max(size, bfs(i, j));
                }
            }
        }
        bw.write(ans + "\n" + size + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    private int bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        visited[y][x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] == 1) {
                    cnt++;
                    visited[yy][xx] = true;
                    q.add(new int[]{yy, xx});
                }
            }
        }
        return cnt;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}
