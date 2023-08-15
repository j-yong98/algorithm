package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20187 {
    int K, H;
    char[] cmd;
    int[][] arr;

    /**
     * 종이 접기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        cmd = new char[2 * K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * K; i++)
            cmd[i] = st.nextToken().charAt(0);
        H = Integer.parseInt(br.readLine());
        int N = 1 << K;
        arr = new int[N][N];
        fold(0, 0, 0, 0, N - 1, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private void fold(int fy, int fx, int y1, int x1, int y2, int x2) {
        if (fy == K && fx == K) {
            arr[y1][x1] = H;
            return;
        }
        char c = cmd[fy + fx];
        if (c == 'U') {
            //길이가 8인 사각 0, 7 -> 0, 3
            fold(fy + 1, fx, y1, x1, (y1 + y2) / 2, x2);

            //피면 크기가 2^접은 횟수만큼
            for (int i = 0; i < 1 << (K - fy); i++) {
                for (int j = x1; j <= x2; j++) {
                    arr[y2 - i][j] = arr[y1 + i][j] ^ 2;
                }
            }
        } else if (c == 'D') {
            //0, 7 -> 4, 7
            fold(fy + 1, fx, (y1 + y2) / 2 + 1, x1, y2, x2);

            // 0 -> 2, 1->3 = x ^ 2
            for (int i = 0; i < 1 << (K - fy); i++) {
                for (int j = x1; j <= x2; j++) {
                    arr[y1 + i][j] = arr[y2 - i][j] ^ 2;
                }
            }
        } else if (c == 'L') {
            //0, 7 -> 0, 3
            fold(fy, fx + 1, y1, x1, y2, (x1 + x2) / 2);
            for (int i = y1; i <= y2; i++) {
                for (int j = 0; j < 1 << (K - fx); j++) {
                    arr[i][x2 - j] = arr[i][x1 + j] ^ 1;
                }
            }
        } else if (c == 'R') {
            //0, 7 -> 4, 7
            fold(fy, fx + 1, y1, (x1 + x2) / 2 + 1, y2, x2);

            for (int i = y1; i <= y2; i++) {
                for (int j = 0; j < 1 << (K - fx); j++) {
                    arr[i][x1 + j] = arr[i][x2 - j] ^ 1;
                }
            }
        } else
            throw new IllegalArgumentException();
    }
}
