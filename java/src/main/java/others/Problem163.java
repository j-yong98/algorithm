package others;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem163 {
    final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int T;
    int n;
    char[][] arr;
    boolean[][] visited;
    Deque<int[]> q;

    int click;

    /**
     * 파핑파핑 지뢰찾기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            visited = new boolean[n][n];
            q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++)
                    arr[i][j] = line.charAt(j);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == '.' && checkRound(i, j))
                        q.add(new int[]{i, j});
                }
            }
            click = 0;
            while(!q.isEmpty()) {
                int[] pos = q.pollFirst();
                if (!visited[pos[0]][pos[1]]) {
                    viewMine(pos[0], pos[1]);
                    click++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] == '.')
                        click++;
                }
            }
            bw.write("#" + t + " " + click + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean checkRound(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx) && arr[yy][xx] == '*')
                return false;
        }
        return true;
    }

    private void viewMine(int y, int x) {
        boolean flag = false;
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx) || arr[yy][xx] == '.') continue;
            return ;
        }
        if (!flag) {
            for (int i = 0; i < 8; i++) {
                int yy = y + dy[i];
                int xx = x + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx])
                    viewMine(yy, xx);
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
