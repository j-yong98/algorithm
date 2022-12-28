package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem44 {
    int n, m;
    int[][] arr;

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private void move(int y, int x) {
        int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int max = 0;
        int maxY = -1;
        int maxX = -1;
        for (int i = 0; i < 8; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx)) {
                if (max < arr[yy][xx]) {
                    max = arr[yy][xx];
                    maxY = yy;
                    maxX = xx;
                }
            }
        }
        int tmp = arr[y][x];
        arr[y][x] = arr[maxY][maxX];
        arr[maxY][maxX] = tmp;
    }

    private void simulate(int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == x) {
                    move(i, j);
                    return;
                }
            }
        }
    }

    private void print() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i <= n * n; i++) {
                simulate(i);
            }
        }
        print();
    }
}
