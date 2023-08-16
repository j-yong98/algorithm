package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2448 {
    int N;
    char[][] arr;
    /**
     * 별찍기 11
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new char[N][2 * N];
        for (int i = 0; i < N; i++)
            Arrays.fill(arr[i], ' ');
        star(N / 3, 0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private void star(int n, int y, int x) {
        if (n == 1) {
            int yy = 0;
            int l = 2;
            int r = 2;
            while (yy < 3 && (l >= 0 && r < 5)) {
                for (int i = l; i <= r; i++) {
                    if (yy == 1 && i == 2) continue;
                    arr[yy + y][i + x] = '*';
                }
                yy++;
                l--;
                r++;
            }
            return;
        }
        int size = n / 2;
        star(size, y, x + 3 * size);
        star(size, y + 3 * size , x);
        star(size, y + 3 * size, x + 3 * n);
    }
}
