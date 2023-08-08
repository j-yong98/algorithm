package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16927 {
    final int[] DY = {0, 0, 1, 0, -1};
    final int[] DX = {0, 1, 0, -1, 0};
    int N, M, R;
    int[][] arr;

    /**
     *  배열 돌리기 2
     *  나머지 연산을 통해 시간 개선
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
        int min = Math.min(N, M);
        for (int i = 0; i < min / 2; i++)
            rotate(arr, i, i, N - i * 2, M - i * 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void rotate(int[][] arr, int r, int c, int rSize, int cSize) {
        int repeat = R % ((rSize + cSize) * 2 - 4);
        for (int u = 0; u < repeat; u++) {
            int d = 1, cnt = 0;
            int pre = arr[r][c];
            int y = r;
            int x = c;
            while (true) {
                int yy = y + DY[d];
                int xx = x + DX[d];
                cnt++;
                if (d % 2 == 0) {
                    if (cnt == rSize - 1) {
                        d += 1;
                        cnt = 0;
                    }
                } else {
                    if (cnt == cSize - 1) {
                        d += 1;
                        cnt = 0;
                    }
                }
                if (d == 5) break;
                arr[y][x] = arr[yy][xx];
                y = yy;
                x = xx;
            }
            arr[y][x] = pre;
        }
    }
}
