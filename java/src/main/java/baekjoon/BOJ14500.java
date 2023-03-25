package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    int n, m;
    int[][] arr;
    int[][] block_size = {
            {1, 4}, {2, 2}, {3, 2}, {3, 2}, {2, 3}
    };
    int[][][] block = {
            {{1, 1, 1, 1}},
            {{1, 1}, {1, 1}},
            {{1, 0}, {1, 0}, {1, 1}},
            {{1, 0}, {1, 1}, {0, 1}},
            {{1, 1, 1}, {0, 1, 0}}
    };
    int ans = 0;
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
    private int getSum(int seq, int y, int x) {
        int sum = 0;
        int[] size = block_size[seq];
        if (!inRange(y + size[0] - 1, x + size[1] - 1))
            return 0;
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                if (block[seq][i][j] == 1)
                    sum += arr[i + y][j + x];
            }
        }
        return sum;
    }
    private void getMaxScore(int seq) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, getSum(seq, i, j));
            }
        }
    }
    private void reversal(int seq) {
        int[] size = block_size[seq];
        int[][] tmp = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++)
                tmp[i][size[1] - 1 - j] = block[seq][i][j];
        }
        block[seq] = tmp;
    }

    private void rotate(int seq) {
        int[] size = block_size[seq];
        int[][] tmp = new int[size[1]][size[0]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++)
                tmp[j][size[0] - 1 - i] = block[seq][i][j];
        }
        block[seq] = tmp;
        int temp = size[0];
        block_size[seq][0] = size[1];
        block_size[seq][1] = temp;
    }

    /**
     * 테트로미노
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                rotate(i);
                getMaxScore(i);
                reversal(i);
                getMaxScore(i);
                reversal(i);
            }
        }
        System.out.println(ans);
    }
}
