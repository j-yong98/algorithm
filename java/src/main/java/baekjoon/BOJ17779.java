package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {
    int n;
    int[][] arr;
    int[][] tmp;
    int ans = Integer.MAX_VALUE;

    private int populationDiff(int[][] map) {
        int[] population = new int[5 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                population[map[i][j]] += arr[i][j];
        }
        return Arrays.stream(population, 1, 6).max().getAsInt() - Arrays.stream(population, 1, 6).min().getAsInt();
    }

    private void divide(int x, int y, int d1, int d2) {
        int[][] border = {
                {0, 0, 0, 0},
                {1, 1, x + d1, y},
                {1, y + 1, x + d2, n},
                {x + d1, 1, n, y - d1 + d2 - 1},
                {x + d2 + 1, y - d1 + d2, n, n}
        };
        for (int k = 1; k <= 4; k++) {
            for (int i = border[k][0]; i <= border[k][2]; i++) {
                for (int j = border[k][1]; j <= border[k][3]; j++) {
                    if (tmp[i][j] == 5) continue;
                    tmp[i][j] = k;
                }
            }
        }
    }
    private void makeBorder(int x, int y, int d1, int d2) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                tmp[i][j] = 0;
        }
        int left = 0;
        int right = 0;
        int dl = -1;
        int dr = 1;
        for (int i = x; i <= x + d1 + d2; i++) {
            for (int j = y + left; j <= y + right; j++)
                tmp[i][j] = 5;
            if (y - d1 >= y + left)
                dl = 1;
            if (y + d2 <= y + right)
                dr = -1;
            left += dl;
            right += dr;
        }
    }
    /**
     * 게리멘더링 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        tmp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int d1 = 1; d1 <= n; d1++) {
                    for (int d2 = 1; d2 <= n; d2++) {
                        if (i + d1 + d2 > n || j - d1 < 1 || j + d2 > n)
                            continue;
                        makeBorder(i, j, d1, d2);
                        divide(i, j, d1, d2);
                        ans = Math.min(ans, populationDiff(tmp));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
