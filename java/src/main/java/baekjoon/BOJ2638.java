package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ2638 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int AIR = 0;
    final int CHEESE = 1;
    final int OUT = 2;
    int n, m;
    int[][] arr;
    int ans = 0;

    /**
     * 치즈
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }
        while (!isFinish()) {
            ans++;
            displayOut();
            removeCheese();
            displayAir();
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isFinish() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == CHEESE)
                    return false;
            }
        }
        return true;
    }

    private void displayOut() {
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && arr[y][x] == AIR) {
                    arr[y][x] = OUT;
                    q.add(new int[]{y, x});
                }
            }
        }
    }

    private void removeCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == CHEESE && contactAir(i, j))
                    arr[i][j] = AIR;
            }
        }
    }

    private boolean contactAir(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx) && arr[yy][xx] == OUT)
                cnt++;
        }
        if (cnt >= 2)
            return true;
        return false;
    }
    private void displayAir() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == OUT)
                    arr[i][j] = AIR;
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
