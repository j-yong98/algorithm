package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12100 {
    final int TRIES = 5;
    final int DIR = 4;
    int n;
    int[][] board;
    Stack<int[][]> save = new Stack<>();
    int ans = Integer.MIN_VALUE;
    private int getMaxValue() {
        return Arrays.stream(board).flatMapToInt(Arrays::stream).max().getAsInt();
    }
    private void rotate(int[][] src) {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - 1 - i] = src[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                src[i][j] = tmp[i][j];
            }
        }
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void drop() {
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] == 0)
                    continue;
                tmp[idx--] = board[j][i];
            }
            for (int j = 0; j < n; j++)
                board[j][i] = tmp[j];
        }
    }
    private int[][] copy(int[][] src) {
        int[][] dst = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dst[i][j] = src[i][j];
            }
        }
        return dst;
    }
    private void calc() {
        int dy = -1;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int y = j + dy;
                if (!inRange(y, i)) {
                    tmp[j][i] = board[j][i];
                    continue;
                }
                if (board[j][i] == board[y][i]) {
                    tmp[j][i] = board[j][i] + board[y][i];
                    board[j][i] = 0;
                    board[y][i] = 0;
                }
                else
                    tmp[j][i] = board[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }
    private void move(int d) {
        for (int i = 0; i < d; i++)
            rotate(board);
        drop();
        calc();
        drop();
        for (int i = 0; i < DIR - d; i++)
            rotate(board);
    }
    private void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void simulate(int seq) {
        if (seq == TRIES) {
            int val = getMaxValue();
            ans = Math.max(ans, val);
            return ;
        }
        for (int i = 0; i < DIR; i++) {
            save.push(copy(board));
            move(i);
            simulate(seq + 1);
            board = save.pop();
        }
    }
    /**
     * 2048(easy)
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulate(0);
        System.out.println(ans);
    }
}
