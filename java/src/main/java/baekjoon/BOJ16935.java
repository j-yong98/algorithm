package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {
    int N, M, R;
    int[][] arr;

    /**
     * 배열 돌리기 3
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
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1:
                    reverseUpDown();
                    break;
                case 2:
                    reverseLeftRight();
                    break;
                case 3:
                    rotateRight();
                    break;
                case 4:
                    rotateLeft();
                    break;
                case 5:
                    divPart1();
                    break;
                case 6:
                    divPart2();
                    break;
            }
        }
        printMap();
    }

    private void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void reverseUpDown() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                tmp[i][j] = arr[N - i - 1][j];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                arr[i][j] = tmp[i][j];
        }
    }

    private void reverseLeftRight() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                tmp[i][j] = arr[i][M - j - 1];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                arr[i][j] = tmp[i][j];
        }
    }

    private void rotateRight() {
        int[][] tmp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                tmp[j][N - i - 1] = arr[i][j];
        }

        arr = tmp;
        swap();
    }

    private void rotateLeft() {
        int[][] tmp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                tmp[i][j] = arr[j][M - i - 1];
        }

        arr = tmp;
        swap();
    }

    /**
     * 1->2->3->4->1
     * 1 -> 0 <= r < N / 2, 0 <= c < M / 2
     * 2 -> 0 <= r < N / 2, M / 2 <= c < M
     * 3 -> N / 2 <= r < N, M / 2 <= c < M
     * 4 -> N / 2 <= r < N, 0 <= c < M / 2
     * */
    private void divPart1() {
        int[][] tmp = new int[N][M];
        int halfN = N / 2;
        int halfM = M / 2;

        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++)
                tmp[i][j + halfM] = arr[i][j];
        }

        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < M; j++)
                tmp[i + halfN][j] = arr[i][j];
        }

        for (int i = halfN; i < N; i++) {
            for (int j = halfM; j < M; j++)
                tmp[i][j - halfM] = arr[i][j];
        }

        for (int i = halfN; i < N; i++) {
            for (int j = 0; j < halfM; j++)
                tmp[i - halfN][j] = arr[i][j];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                arr[i][j] = tmp[i][j];
        }
    }

    /**
     * 1->4->3->2->1
     * 1 -> 0 <= r < N / 2, 0 <= c < M / 2
     * 2 -> 0 <= r < N / 2, M / 2 <= c < M
     * 3 -> N / 2 <= r < N, M / 2 <= c < M
     * 4 -> N / 2 <= r < N, 0 <= c < M / 2
     * */
    private void divPart2() {
        int[][] tmp = new int[N][M];
        int halfN = N / 2;
        int halfM = M / 2;

        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++)
                tmp[i + halfN][j] = arr[i][j];
        }

        for (int i = halfN; i < N; i++) {
            for (int j = 0; j < halfM; j++)
                tmp[i][j + halfM] = arr[i][j];
        }

        for (int i = halfN; i < N; i++) {
            for (int j = halfM; j < M; j++)
                tmp[i - halfN][j] = arr[i][j];
        }

        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < M; j++)
                tmp[i][j - halfM] = arr[i][j];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                arr[i][j] = tmp[i][j];
        }
    }

    private void swap() {
        N ^= M;
        M ^= N;
        N ^= M;
    }
}
