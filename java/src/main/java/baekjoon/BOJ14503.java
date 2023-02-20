package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    final int BLANK = 0;
    final int CLEAN = 2;
    int n, m;
    int r, c, d;
    int[][] arr;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    int cnt = 0;
    public boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    public void clean(int y, int x) {
        if (arr[y][x] == BLANK)
            arr[y][x] = CLEAN;
    }

    public boolean checkSide(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx) && arr[yy][xx] == BLANK)
                return true;
        }
        return false;
    }
    public int rotate(int dir) {
        /**
         * 0 -> 3
         * 1 -> 0
         * 2 -> 1
         * 3 -> 2
         */
        return (dir - 1 + 100) % 4;
    }
    public boolean look(int y, int x, int dir) {
        int yy = y + dy[dir];
        int xx = x + dx[dir];
        if (inRange(yy, xx) && arr[yy][xx] == BLANK)
            return true;
        return false;
    }
    public boolean canBack(int y, int x, int dir) {
        //상 우 하 좌
        /**
         * (pos + 2) % 4
         * 상 -> 하 0 -> 2
         * 우 -> 좌 1 -> 3
         * 하 -> 상 2 -> 0
         * 좌 -> 우 3 -> 1
         */
        int newDir = (dir + 2) % 4;
        int yy = y + dy[newDir];
        int xx = x + dx[newDir];
        return inRange(yy, xx) && (arr[yy][xx] == BLANK || arr[yy][xx] == CLEAN);
    }

    public void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void simulate() {
        while(true) {
            if (arr[r][c] == BLANK) {
                clean(r, c);
                cnt++;
            }
            if (checkSide(r, c)) {
                d = rotate(d);
                if (look(r, c, d)) {
                    r = r + dy[d];
                    c = c + dx[d];
                }
            } else {
                if (!canBack(r, c, d))
                    break;
                int newDir = (d + 2) % 4;
                r = r + dy[newDir];
                c = c + dx[newDir];
            }
        }
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulate();
        System.out.println(cnt);
        return cnt;
    }
}
