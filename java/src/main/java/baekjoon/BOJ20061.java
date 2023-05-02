package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20061 {
    final int BLANK = 0;
    final int PUT = 1;
    final int SIZE = 4;
    final int[][] dy = {{}, {0}, {0, 0}, {0, 1}};
    final int[][] dx = {{}, {0}, {0, 1}, {0, 0}};

    int[][] blue = new int[SIZE][SIZE + 2];
    int[][] green = new int[SIZE + 2][SIZE];

    int n;
    int score = 0;
    int tile = 0;
    /**
     *  모노미도미노 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            putBlock(t, r, c);
            score += getScore();
        }
        tile = Arrays.stream(blue).flatMapToInt(Arrays::stream).sum() + Arrays.stream(green).flatMapToInt(Arrays::stream).sum();
        bw.write(score + "\n");
        bw.write(tile + "\n");
        bw.flush();
        bw.close();
    }

    private int getScore() {
        int res = 0;
        res += checkBlue();
        res += checkGreen();
        return res;
    }

    private int checkBlue() {
        int s = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 2; i < SIZE + 2; i++) {
                int cnt = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (blue[j][i] == PUT)
                        cnt++;
                }
                if (cnt == SIZE) {
                    flag = true;
                    s += 1;
                    removeBlue(i);
                    break ;
                }
                flag = false;
            }
        }
        checkSpecialBlue();
        return s;
    }

    private void removeBlue(int x) {
        for (int i = x; i > 0; i--) {
            for (int j = 0; j < SIZE; j++)
                blue[j][i] = blue[j][i - 1];
        }
        for (int j = 0; j < SIZE; j++)
            blue[j][0] = BLANK;
    }

    private void checkSpecialBlue() {
        boolean isPut = false;
        int step = 2;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (blue[j][i] == 1) {
                    isPut = true;
                    step = step - i;
                    break;
                }
            }
            if (isPut)
                break ;
        }
        if (!isPut)
            return ;
        for (int i = SIZE + 2 - 1; i >= 2; i--) {
            for (int j = 0; j < SIZE; j++)
                blue[j][i] = blue[j][i - step];
        }
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < SIZE; j++)
                blue[j][i] = 0;
        }
    }

    private int checkGreen() {
        int s = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 2; i < SIZE + 2; i++) {
                int cnt = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (green[i][j] == PUT)
                        cnt++;
                }
                if (cnt == SIZE) {
                    flag = true;
                    s += 1;
                    removeGreen(i);
                    break ;
                }
                flag = false;
            }
        }
        checkSpecialGreen();
        return s;
    }

    private void removeGreen(int y) {
        for (int i = y; i > 0; i--) {
            for (int j = 0; j < SIZE; j++)
                green[i][j] = green[i - 1][j];
        }
        for (int j = 0; j < SIZE; j++)
            green[0][j] = BLANK;
    }

    private void checkSpecialGreen() {
        boolean isPut = false;
        int step = 2;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (green[i][j] == 1) {
                    isPut = true;
                    step = step - i;
                    break;
                }
            }
            if (isPut)
                break ;
        }
        if (!isPut)
            return ;
        for (int i = SIZE + 2 - 1; i >= 2; i--) {
            for (int j = 0; j < SIZE; j++)
                green[i][j] = green[i - step][j];
        }
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < SIZE; j++)
                green[i][j] = 0;
        }
    }

    private void putBlock(int t, int r, int c) {
        putBlue(t, r);
        putGreen(t, c);
    }

    private void putBlue(int t, int r) {
        int c = 0;
        for (int i = 1; i < SIZE + 2; i++) {
            boolean flag = true;
            for (int d = 0; d < dx[t].length; d++) {
                int y = r + dy[t][d];
                int x = i + dx[t][d];
                if (inRange(y, x, SIZE, SIZE + 2) && blue[y][x] != PUT)
                    continue;
                flag = false;
                break ;
            }
            if (flag)
                c = i;
            else break;
        }
        for (int d = 0; d < dx[t].length; d++) {
            int y = r + dy[t][d];
            int x = c + dx[t][d];
            blue[y][x] = PUT;
        }
    }

    private void putGreen(int t, int c) {
        int r = 0;
        for (int i = 1; i < SIZE + 2; i++) {
            boolean flag = true;
            for (int d = 0; d < dx[t].length; d++) {
                int y = i + dy[t][d];
                int x = c + dx[t][d];
                if (inRange(y, x, SIZE + 2, SIZE) && green[y][x] != PUT)
                    continue;
                flag = false;
                break ;
            }
            if (flag)
                r = i;
            else break;
        }
        for (int d = 0; d < dy[t].length; d++) {
            int y = r + dy[t][d];
            int x = c + dx[t][d];
            green[y][x] = PUT;
        }
    }

    private boolean inRange(int y, int x, int r, int c) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}
