package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ19237 {
    final int BLANK = 0;
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, -1, 1};
    int n, m, k;
    int[][][] priority;
    int[][] arr;
    int[][] tmp;
    int[][][] smell;
    int[] dir;
    int cnt = 0;

    /**
     * 어른 상어
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        tmp = new int[n][n];
        smell = new int[n][n][2];
        priority = new int[m + 1][4][4];
        dir = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++)
            dir[i] = Integer.parseInt(st.nextToken()) - 1;
        for (int k = 1; k <= m; k++) {
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++)
                    priority[k][i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
        while (!onlyOne() && cnt <= 1000) {
            cnt++;
            leaveSmell();
            init(tmp);
            move();
            copy(tmp, arr);
            removeSmell();
        }
        if (cnt == 1001)
            cnt = -1;
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
    private void init(int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = 0;
        }
    }
    private void copy(int[][] src, int[][] dst) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dst[i][j] = src[i][j];
        }
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void move() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != BLANK) {
                    boolean flag = false;
                    int[] m = priority[arr[i][j]][dir[arr[i][j]]];
                    for (int d = 0; d < 4; d++) {
                        int y = i + DY[m[d]];
                        int x = j + DX[m[d]];
                        if (inRange(y, x) && smell[y][x][0] == 0) {
                            flag = true;
                            if (tmp[y][x] == BLANK || tmp[y][x] > arr[i][j]) {
                                tmp[y][x] = arr[i][j];
                                dir[arr[i][j]] = m[d];
                            }
                            break ;
                        }
                    }
                    if (!flag) {
                        for (int d = 0; d < 4; d++) {
                            int y = i + DY[m[d]];
                            int x = j + DX[m[d]];
                            if (inRange(y, x) && smell[y][x][0] == arr[i][j]) {
                                tmp[y][x] = arr[i][j];
                                dir[arr[i][j]] = m[d];
                                break ;
                            }
                        }
                    }
                }
            }
        }
    }
    private int getDir(int d) {
        if (d == 0)
            return 1;
        if (d == 1)
            return 0;
        if (d == 2)
            return 3;
        if (d == 3)
            return 2;
        throw new IllegalArgumentException();
    }
    private void removeSmell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (smell[i][j][1] > 0) {
                    smell[i][j][1] -= 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (smell[i][j][0] != 0 && smell[i][j][1] == 0)
                    smell[i][j][0] = 0;
            }
        }
    }
    private void leaveSmell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != BLANK) {
                    smell[i][j][0] = arr[i][j];
                    smell[i][j][1] = k;
                }
            }
        }
    }
    private boolean onlyOne() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != BLANK && arr[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
}
