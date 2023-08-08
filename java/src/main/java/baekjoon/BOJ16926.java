package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    final int[] DY = {0, 1, 0, -1, 0};
    final int[] DX = {0, 0, 1, 0, -1};
    int N, M, R;
    int[][] arr;

    /**
     * 배열 돌리기 1
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            arr = rotate(arr);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private int[][] rotate(int[][] arr) {
        int[][] tmp = new int[N][M];
        int r = N, c = M;
        int D = Math.min(N / 2, M / 2);
        for (int d = 0; d < D; d++) {
            int y = d, x = d;
            tmp[y][x] = arr[y][x + 1];
            int repeat = (r + c) * 2 - 4 - 1;
            int dir = 1;
            int cnt = 0;
            while (repeat-- > 0) {
                int yy = y + DY[dir];
                int xx = x + DX[dir];
                cnt++;
                if (dir % 2 == 1) {
                    if (cnt == r - 1) {
                        dir += 1;
                        cnt = 0;
                    }
                } else {
                    if (cnt == c - 1) {
                        dir += 1;
                        cnt = 0;
                    }
                }
                tmp[yy][xx] = arr[y][x];
                y = yy;
                x = xx;
            }
            r -= 2;
            c -= 2;
        }
        return tmp;
    }
}
