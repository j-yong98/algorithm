package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17136 {
    final int SIZE = 10;
    int[][] arr = new int[SIZE][SIZE];
    int[] quantitiy = new int[]{0, 5, 5, 5, 5, 5};
    int ans = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    private void dfs(int y, int x, int cnt) {
        if (y == SIZE) {
            ans = Math.min(ans, cnt);
            return ;
        }
        if (x == SIZE) {
            dfs(y + 1, 0, cnt);
            return ;
        }
        if (arr[y][x] == 0) {
            dfs(y, x + 1, cnt);
            return ;
        }
        for (int i = 5; i >= 1; i--) {
            if (canAttach(y, x, i)) {
                attach(y, x, i, 0);
                dfs(y, x + 1, cnt + 1);
                attach(y, x, i, 1);
            }
        }
    }

    private boolean canAttach(int y, int x, int len) {
        if (quantitiy[len] == 0)
            return false;
        if (!inRange(y + len - 1, x + len - 1))
            return false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[y + i][x + j] == 0)
                    return false;
            }
        }
        return true;
    }

    private void attach(int y, int x, int len, int value) {
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++)
                arr[i][j] = value;
        }
        if (value == 0)
            quantitiy[len]--;
        else
            quantitiy[len]++;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < SIZE && x >= 0 && x < SIZE;
    }
}
