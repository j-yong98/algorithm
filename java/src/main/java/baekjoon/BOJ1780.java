package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    int N;
    int[][] arr;
    int[] count = new int[3];

    /**
     * 종이의 개수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
        }
        getCnt(0, 0, N);
        for (int i = 0; i < 3; i++)
            sb.append(count[i]).append("\n");
        System.out.print(sb);
    }

    private void getCnt(int y, int x, int n) {
        if (n == 1) {
            count[arr[y][x]] += 1;
            return;
        }
        if (allEqual(y, x, n)) {
            count[arr[y][x]] += 1;
            return;
        }

        int next = n / 3;
        for (int i = y; i < y + n; i += next) {
            for (int j = x; j < x + n; j += next) {
                getCnt(i, j, next);
            }
        }
    }

    private boolean allEqual(int y, int x, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[y + i][x + j] != arr[y][x]) return false;
            }
        }
        return true;
    }
}
