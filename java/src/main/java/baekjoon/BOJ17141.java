package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ17141 {
    final int MAX = 1_000_000_000;
    final int BLANK = 0;
    final int WALL = 1;
    final int VIRUS = 2;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, 1, -1};
    int n, m;
    int[][] arr;
    List<int[]> virusList = new ArrayList<>();
    List<Integer> selected = new ArrayList<>();
    int ans = MAX;

    /**
     * 연구소 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == VIRUS)
                    virusList.add(new int[]{i, j});
            }
        }
        dfs(0, 0);
        ans = ans == MAX ? -1 : ans;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int l, int cnt) {
        if (cnt == m) {
            ans = Math.min(ans, bfs());
            return;
        }
        if (l == virusList.size())
            return;
        selected.add(l);
        dfs(l + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        dfs(l + 1, cnt);
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], MAX);

        for (Integer num : selected) {
            int[] pos = virusList.get(num);
            dist[pos[0]][pos[1]] = 0;
            q.add(pos);
        }

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && arr[y][x] != WALL && dist[y][x] == MAX) {
                    q.add(new int[]{y, x});
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == WALL) {
                    continue;
                }
                max = Math.max(max, dist[i][j]);
            }
        }
        return max;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
