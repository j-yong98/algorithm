package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1331 {
    final int[] DY = {-2, -2, -1, 1, 2, 2, -1, 1};
    final int[] DX = {-1, 1, 2, 2, -1, 1, -2, -2};
    final int SIZE = 6;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[SIZE + 1][SIZE + 1];
        boolean flag = true;
        String pos = br.readLine();
        int y = (pos.charAt(0) - 'A') + 1;
        int x = (pos.charAt(1) - '0');
        int[] start = new int[]{y, x};
        int[] now = new int[]{y, x};
        for (int i = 0; i < SIZE * SIZE - 1; i++) {
            pos = br.readLine();
            y = (pos.charAt(0) - 'A') + 1;
            x = pos.charAt(1) - '0';
            if (canGo(y, x, now) && !visited[y][x]) {
                visited[y][x] = true;
            } else {
                flag = false;
                break;
            }
            now[0] = y;
            now[1] = x;
        }
        if (flag) {
            if (!canGo(start[0], start[1], now))
                flag = false;
        }
        System.out.println(flag ? "Valid" : "Invalid");
    }

    private boolean canGo(int y, int x, int[] pos) {
        for (int i = 0; i < 8; i++) {
            int yy = pos[0] + DY[i];
            int xx = pos[1] + DX[i];
            if (inRange(yy, xx) && yy == y && xx == x)
                return true;
        }
        return false;
    }
    private boolean inRange(int y, int x) {
        return y >= 1 && y <= SIZE && x >= 1 && x <= SIZE;
    }
}
