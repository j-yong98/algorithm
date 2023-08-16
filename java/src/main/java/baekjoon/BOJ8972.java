package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ8972 {
    final char ARDUINO = 'R';
    final char PLAYER = 'I';
    final char BLANK = '.';
    final int[] DY = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    final int[] DX = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    int[] pos = new int[2];
    List<int[]> arduino = new ArrayList<>();
    int R, C;
    char[][] arr;
    int[][] count;
    boolean isDead = false;

    /**
     * 미친 아두이노
     * 구현
     * 좌표 사라지는 것 주의
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        count = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == PLAYER) {
                    pos[0] = i;
                    pos[1] = j;
                } else if (arr[i][j] == ARDUINO) {
                    arduino.add(new int[]{i, j});
                    count[i][j]++;
                }
            }
        }
        String line = br.readLine();
        int L = 0;
        while (L < line.length() && !isDead) {
            int dir = line.charAt(L++) - '0';
            move(dir);
            if (isDead) break;
            crazyMove();
            bomb();
            draw();
        }
        StringBuilder sb = new StringBuilder();
        if (isDead) {
            sb.append("kraj ").append(L).append("\n");
        } else {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private void draw() {
        for (int i = 0; i < R; i++)
            Arrays.fill(arr[i], BLANK);

        arr[pos[0]][pos[1]] = PLAYER;
        for (int[] a : arduino) {
            arr[a[0]][a[1]] = ARDUINO;
        }
    }

    private void bomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (count[i][j] > 1) {
                    clear(i, j);
                    count[i][j] = 0;
                }
            }
        }
    }

    private void clear(int y, int x) {
        arr[y][x] = BLANK;
        for (int i = arduino.size() - 1; i >= 0; i--) {
            int[] p = arduino.get(i);
            if (p[0] == y && p[1] == x) {
                arduino.remove(i);
            }
        }
    }

    private void move(int dir) {
        int yy = pos[0] + DY[dir];
        int xx = pos[1] + DX[dir];

        if (arr[yy][xx] == ARDUINO) {
            isDead = true;
            return;
        }
        arr[pos[0]][pos[1]] = BLANK;
        arr[yy][xx] = PLAYER;
        pos[0] = yy;
        pos[1] = xx;
    }

    private void crazyMove() {
        for (int[] a : arduino) {
            int dir = getMinDir(a[0], a[1]);
            int yy = a[0] + DY[dir];
            int xx = a[1] + DX[dir];
            if (yy == pos[0] && xx == pos[1]) {
                isDead = true;
                return;
            }
            count[yy][xx]++;
            count[a[0]][a[1]]--;
            a[0] = yy;
            a[1] = xx;
        }
    }

    private int getMinDir(int y, int x) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            int yy = y + DY[i];
            int xx = x + DX[i];
            if (inRange(yy, xx)) {
                int d = getDist(yy, xx);
                if (d < min) {
                    min = d;
                    res = i;
                }
            }
        }
        return res;
    }

    private int getDist(int y, int x) {
        return Math.abs(pos[0] - y) + Math.abs(pos[1] - x);
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
