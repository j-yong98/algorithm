package baekjoon;

import java.io.*;

public class BOJ19235 {
    final int BLANK = 0;
    final int SIZE = 4;
    final int[][][] BLOCKS = {
            null, {{0}, {0}}, {{0, 0}, {0, 1}}, {{0, 1}, {0, 0}}
    };
    int[][][] arr = new int[2][SIZE + 2][SIZE];

    /**
     * 모노미노도미노
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int bomb = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int t = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]);
            putBlock(arr[0], BLOCKS[t], t, x); //green
            bomb += removeBlock(arr[0]);
            checkArea(arr[0]);
            if (t == 2 || t == 3) {
                t = t == 2 ? 3 : 2;
            }
            putBlock(arr[1], BLOCKS[t], t, y);
            bomb += removeBlock(arr[1]);
            checkArea(arr[1]);
        }
        int cnt = 0;
        for (int i = 0; i < SIZE + 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[0][i][j] != BLANK)
                    cnt++;
                if (arr[1][i][j] != BLANK)
                    cnt++;
            }
        }
        bw.write(bomb + "\n" + cnt);
        bw.flush();
        bw.close();
        br.close();
    }

    private void printBoard(int[][] board, int y, int x, int type) {
        System.out.println("y : " + y + " " + "x : " + x + " type: " + type);
        for (int i = 0; i < SIZE + 2; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println("=======================");
    }

    private void putBlock(int[][] board, int[][] block, int type, int x) {
        int tmp = 0;
        for (int i = 1; i < SIZE + 2; i++) {
            boolean flag = true;
            for (int d = 0; d < block[0].length; d++) {
                int yy = i + block[0][d];
                int xx = x + block[1][d];
                if (inRange(yy, xx) && board[yy][xx] == BLANK) continue;
                flag = false;
                break;
            }
            if (!flag)
                break;
            tmp = i;
        }
        for (int d = 0; d < block[0].length; d++) {
            int yy = tmp + block[0][d];
            int xx = x + block[1][d];
            board[yy][xx] = type == 2 ? 2 : 1;
        }
    }

    private int removeBlock(int[][] board) {
        int res = 0;
        for (int i = 0; i < SIZE + 2; i++) {
            int cnt = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != BLANK)
                    cnt += 1;
            }

            if (cnt != SIZE) continue;

            res += 1;
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = BLANK;
            }
            int[][] tmp = fallDown(board);
            for (int r = 0; r < SIZE + 2; r++) {
                for (int c = 0; c < SIZE; c++)
                    board[r][c] = tmp[r][c];
            }
            break ;
        }
        if (res > 0)
            return removeBlock(board) + 1;
        return 0;
    }

    private int[][] fallDown(int[][] board) {
        int[][] tmp = new int[SIZE + 2][SIZE];
        for (int i = SIZE + 2 - 1; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == BLANK) continue;
                int[][] block = BLOCKS[board[i][j]];
                putBlock(tmp, block, board[i][j], j);
                for (int d = 0; d < block[0].length; d++) {
                    int y = i + block[0][d];
                    int x = j + block[1][d];
                    board[y][x] = BLANK;
                }
            }
        }
        return tmp;
    }

    private void checkArea(int[][] board) {
        int tmp = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board[1][i] == BLANK)
                continue;
            tmp++;
            break;
        }
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == BLANK)
                continue;
            tmp++;
            break;
        }
        if (tmp == 0)
            return;

        for (int i = SIZE + 2 - 1; i >= tmp; i--) {
            for (int j = 0; j < SIZE; j++)
                board[i][j] = board[i - tmp][j];
        }
        for (int i = 0; i < SIZE; i++) {
            board[0][i] = BLANK;
            board[1][i] = BLANK;
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < SIZE + 2 && x >= 0 && x < SIZE;
    }
}
