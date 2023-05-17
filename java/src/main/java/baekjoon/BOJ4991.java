package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BOJ4991 {
    final char ROBOT = 'o';
    final char DUST = '*';
    final char OBSTACLE = 'x';

    int w, h;
    int size = 0;
    int ans;
    char[][] arr;
    int[][] dist;
    List<Position> dusts = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] line = br.readLine().split(" ");
            w = Integer.parseInt(line[0]);
            h = Integer.parseInt(line[1]);
            if (w == 0 && h == 0)
                break ;
            arr = new char[h][w];

            dusts.clear();
            for (int i = 0; i < h; i++) {
                String l = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = l.charAt(j);
                    if (arr[i][j] == DUST)
                        dusts.add(new Position(i, j));
                    else if (arr[i][j] == ROBOT)
                        dusts.add(0, new Position(i, j));
                }
            }

            ans = Integer.MAX_VALUE;
            size = dusts.size();
            dist = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    dist[i][j] = dist[j][i] = bfs(dusts.get(i), dusts.get(j));
                }
            }
            perm(1, 0, 1, 0);
            ans = ans == Integer.MAX_VALUE ? -1 : ans;
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(Position s, Position e) {
        final int[] dy = {-1, 1, 0, 0};
        final int[] dx = {0, 0, -1, 1};

        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];
        visited[s.y][s.x] = true;
        q.add(new int[]{s.y, s.x, 0});

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[0] == e.y && pos[1] == e.x)
                return pos[2];
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] != OBSTACLE) {
                    visited[y][x] = true;
                    q.add(new int[]{y, x, pos[2] + 1});
                }
            }
        }
        return -1;
    }

    private void perm(int l, int from, int visited, int sum) {
        if (l == size) {
            ans = Math.min(ans, sum);
            return ;
        }
        for (int i = 0; i < size; i++) {
            if (dist[from][i] == -1) continue;
            if ((visited & (1 << i)) == 0)
                perm(l + 1, i, visited | (1 << i), sum + dist[from][i]);
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }

    class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
