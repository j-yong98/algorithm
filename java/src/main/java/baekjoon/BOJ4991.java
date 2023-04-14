package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BOJ4991 {
    final char clean = '.';
    final char duty = '*';
    final char furniture = 'x';
    int r, c;
    int[] pos = new int[3];
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    int[] orders;
    char[][] arr = new char[21][21];
    List<int[]> dusts = new ArrayList<>();
    boolean[] checked;
    int ans;

    private boolean inRange(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }

    private int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        visited[pos[0]][pos[1]] = true;
        q.add(new int[]{pos[0], pos[1], 0});
        int sum = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            if (p[0] == dusts.get(orders[idx])[0] && p[1] == dusts.get(orders[idx])[1]) {
                sum += p[2];
                q.clear();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++)
                        visited[i][j] = false;
                }
                visited[p[0]][p[1]] = true;
                q.addLast(new int[]{p[0], p[1], 0});
                idx++;
                if (idx == dusts.size())
                    break ;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int yy = p[0] + dy[i];
                int xx = p[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] != furniture) {
                    visited[yy][xx] = true;
                    q.addLast(new int[]{yy, xx, p[2] + 1});
                }
            }
        }
        if (idx != dusts.size())
            return Integer.MAX_VALUE;
        return sum == 0 ? Integer.MAX_VALUE : sum;
    }

    private void comb(int depth) {
        if (depth == dusts.size()) {
            ans = Math.min(ans, bfs());
            return;
        }
        for (int i = 0; i < dusts.size(); i++) {
            if (!checked[i]) {
                orders[depth] = i;
                checked[i] = true;
                comb(depth + 1);
                checked[i] = false;
            }
        }
    }

    /**
     * 로봇 청소기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = br.readLine().split(" ");
            c = Integer.parseInt(line[0]);
            r = Integer.parseInt(line[1]);
            ans = Integer.MAX_VALUE;
            dusts.clear();
            if (r == 0 && c == 0)
                break;
            for (int i = 0; i < r; i++) {
                String row = br.readLine();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = row.charAt(j);
                    if (arr[i][j] == 'o') {
                        pos[0] = i;
                        pos[1] = j;
                    } else if (arr[i][j] == duty)
                        dusts.add(new int[]{i, j});
                }
            }
            orders = new int[dusts.size()];
            checked = new boolean[dusts.size()];
            comb(0);
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
    }
}
