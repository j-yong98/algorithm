package baekjoon;

import java.io.*;

public class BOJ19235 {
    final int BLANK = 0;
    final int SIZE = 4;
    final int[][][] BLOCKS = {
            null, {{0}, {0}}, {{0, 0}, {0, 1}}, {{0, 1}, {0, 0}}
    };
    int[][] blue = new int[SIZE][SIZE + 2];
    int[][] green = new int[SIZE + 2][SIZE];
    int n;
    int ans = 0;

    /**
     * 모노미노도미노
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int t = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]);
            putBlock(t, y, x);
            ans += bomb();
            checkArea();
        }
        printMap();
        int cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE + 2; j++) {
                if (blue[i][j] != BLANK)
                    cnt++;
            }
        }
        for (int i = 0; i < SIZE + 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (green[i][j] != BLANK)
                    cnt++;
            }
        }
        bw.write(ans + "\n" + cnt);
        bw.flush();
        bw.close();
        br.close();
    }

    private void printMap() {
        System.out.println("blue");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE + 2; j++)
                System.out.print(blue[i][j] + " ");
            System.out.println();
        }
        System.out.println("green");
        for (int i = 0; i < SIZE + 2; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(green[i][j] + " ");
            System.out.println();
        }
        System.out.println("========================");
    }

    private void putBlock(int t, int y, int x) {
        int[][] block = BLOCKS[t];
        int tmp = 0;
        for (int i = 1; i < SIZE + 2; i++) {
            boolean can = true;
            for (int d = 0; d < block[0].length; d++) {
                int yy = y + block[0][d];
                int xx = i + block[1][d];
                if (inRange(yy, xx, SIZE, SIZE + 2) && blue[yy][xx] == BLANK)
                    continue;
                can = false;
                break;
            }
            if (!can)
                break;
            tmp = i;
        }
        for (int d = 0; d < block[0].length; d++) {
            int yy = y + block[0][d];
            int xx = tmp + block[1][d];
            blue[yy][xx] = t;
        }
        tmp = 0;
        for (int i = 1; i < SIZE + 2; i++) {
            boolean can = true;
            for (int d = 0; d < block[0].length; d++) {
                int yy = i + block[0][d];
                int xx = x + block[1][d];
                if (inRange(yy, xx, SIZE + 2, SIZE) && green[yy][xx] == BLANK)
                    continue;
                can = false;
                break;
            }
            if (!can)
                break;
            tmp = i;
        }
        for (int d = 0; d < block[0].length; d++) {
            int yy = tmp + block[0][d];
            int xx = x + block[1][d];
            green[yy][xx] = t;
        }
    }

    private int bomb() {
        int res1 = 0;
        for (int i = 2; i < SIZE + 2; i++) {
            int cnt = 0;
            for (int j = 0; j < SIZE; j++) {
                if (blue[j][i] != BLANK)
                    cnt += 1;
            }
            if (cnt == SIZE) {
                res1 += 1;
                for (int j = 0; j < SIZE; j++)
                    blue[j][i] = BLANK;
                fallDown(blue);
            }
        }
        int res2 = 0;
        for (int i = 2; i < SIZE + 2; i++) {
            int cnt = 0;
            for (int j = 0; j < SIZE; j++) {
                if (green[i][j] != BLANK)
                    cnt++;
            }
            if (cnt == SIZE) {
                res2 += 1;
                for (int j = 0; j < SIZE; j++)
                    green[i][j] = BLANK;
                fallDown(green);
            }
        }
        if (res1 + res2 == 0)
            return 0;
        return res1 + res2 + bomb();
    }

    private void fallDown(int[][] board) {
        if (board == blue) {
            int[][] tmp = new int[SIZE][SIZE + 2];
            for (int i = 0; i < SIZE; i++) {
                int idx = SIZE + 2 - 1;
                for (int j = SIZE + 2 - 1; j >= 0; j--) {
                    if (blue[i][j] == BLANK)
                        continue;
                    if (blue[i][j] == 3) {
                        while (!(tmp[i][idx] == BLANK && tmp[i + 1][idx] == BLANK))
                            idx--;
                        tmp[i][idx] = 2;
                        tmp[i + 1][idx] = 2;
                        idx--;
                        blue[i + 1][j] = BLANK;
                    }
                    else {
                        while (tmp[i][idx] != BLANK)
                            idx--;
                        tmp[i][idx--] = blue[i][j];
                    }
                }
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE + 2; j++)
                    blue[i][j] = tmp[i][j];
            }
        } else {
            int[][] tmp = new int[SIZE + 2][SIZE];
            for (int i = 0; i < SIZE; i++) {
                int idx = SIZE + 2 - 1;
                for (int j = SIZE + 2 - 1; j >= 0; j--) {
                    if (green[j][i] == BLANK)
                        continue;
                    if (green[j][i] == 2) {
                        while (!(tmp[idx][i] == BLANK && tmp[idx][i + 1] == BLANK))
                            idx--;
                        tmp[idx][i] = 2;
                        tmp[idx][i + 1] = 2;
                        idx--;
                        green[j][i + 1] = 0;
                    }
                    else {
                        while (tmp[idx][i] != BLANK)
                            idx--;
                        tmp[idx--][i] = green[j][i];
                    }
                }
            }
            for (int i = 0; i < SIZE + 2; i++) {
                for (int j = 0; j < SIZE; j++)
                    green[i][j] = tmp[i][j];
            }
        }
    }

    private void checkArea() {
        boolean flag = false;
        for (int i = 0; i < SIZE; i++) {
            if (blue[i][1] == BLANK)
                continue;
            flag = true;
            break;
        }
        if (flag) {
            for (int i = SIZE + 2 - 1; i > 0; i--) {
                for (int j = 0; j < SIZE; j++)
                    blue[j][i] = blue[j][i - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                blue[i][0] = BLANK;
                blue[i][1] = BLANK;
            }
        }

        flag = false;
        for (int i = 0; i < SIZE; i++) {
            if (green[1][i] == BLANK)
                continue;
            flag = true;
            break;
        }
        if (flag) {
            for (int i = SIZE + 2 - 1; i > 0; i--) {
                for (int j = 0; j < SIZE; j++)
                    green[i][j] = green[i - 1][j];
            }
            for (int i = 0; i < SIZE; i++) {
                green[0][i] = BLANK;
                green[1][i] = BLANK;
            }
        }
    }

    private boolean inRange(int y, int x, int r, int c) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}
