package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239 {
    final int X = 3;
    final int N = 9;
    int[] row = new int[N];
    int[] col = new int[N];
    int[] area = new int[N];
    int[][] arr = new int[N][N];
    boolean flag = false;
    StringBuilder sb = new StringBuilder();

    /**
     * 스도쿠
     */
    public void soltuion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                arr[i][j] = line.charAt(j) - '0';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) continue;
                row[i] |= 1 << arr[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 0) continue;
                col[i] |= 1 << arr[j][i];
            }
        }
        for (int i = 0; i < N; i += 3) {
            for (int j = 0; j < N; j += 3) {
                for (int r = 0; r < X; r++) {
                    for (int c = 0; c < X; c++) {
                        if (arr[i + r][j + c] == 0) continue;
                        area[(i * X + j) / X] |= 1 << arr[i + r][j + c];
                    }
                }
            }
        }
        backTracking(0, 0);
        System.out.print(sb);
        br.close();
    }

    private void backTracking(int y, int x) {
        if (flag) return;

        if (x == N) {
            backTracking(y + 1, 0);
            return;
        }
        if (y == N) {
            flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    sb.append(arr[i][j]);
                sb.append("\n");
            }
            return;
        }
        if (arr[y][x] != 0) {
            backTracking(y, x + 1);
            return;
        }

        for (int i = 1; i <= N; i++) {
            int a = getArea(y, x);
            if (!check(y, x, a, i)) continue;
            arr[y][x] = i;
            row[y] |= (1 << i);
            col[x] |= (1 << i);
            area[a] |= (1 << i);
            backTracking(y, x + 1);
            arr[y][x] = 0;
            row[y] &= ~(1 << i);
            col[x] &= ~(1 << i);
            area[a] &= ~(1 << i);
        }
    }

    private boolean check(int y, int x, int a, int val) {
        if ((row[y] & (1 << val)) != 0) return false;
        if ((col[x] & (1 << val)) != 0) return false;
        if ((area[a] & (1 << val)) != 0) return false;
        return true;
    }

    private int getArea(int y, int x) {
        while (y % X != 0)
            y--;
        while (x % X != 0)
            x--;
        return (y * X + x) / X;
    }
}
