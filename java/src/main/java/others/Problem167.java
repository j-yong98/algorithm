package others;

import java.io.*;

public class Problem167 {
    int T;
    int n, w, h;
    int[][] arr;
    int ans;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            w = Integer.parseInt(line[1]);
            h = Integer.parseInt(line[2]);
            arr = new int[h][w];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < w; j++)
                    arr[i][j] = Integer.parseInt(line[j]);
            }
            simulate(0, arr);
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void printMap(int[][] map) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

    private int[][] copyArr(int[][] src) {
        int[][] tmp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                tmp[i][j] = src[i][j];
            }
        }
        return tmp;
    }

    private void simulate(int cnt, int[][] map) {
        if (cnt == n) {
            int res = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] != 0)
                        res += 1;
                }
            }
            ans = Math.min(ans, res);
            return;
        }
        for (int i = 0; i < w; i++) {
            int[][] dst = copyArr(map);
            drop(i, dst);
            simulate(cnt + 1, dst);
        }
    }

    private void drop(int col, int[][] map) {
        for (int row = 0; row < h; row++) {
            if (isCrash(row, col, map)) {
                bomb(row, col, map);
                fallDown(map);
                break;
            }
        }
    }

    private boolean isCrash(int r, int c, int[][] map) {
        if (map[r][c] != 0)
            return true;
        return false;
    }

    private void bomb(int r, int c, int[][] map) {
        int num = map[r][c];
        map[r][c] = 0;
        for (int i = 1; i < num; i++) {
            if (inRange(r + i, c) && map[r + i][c] != 0)
                bomb(r + i, c, map);
            if (inRange(r, c + i) && map[r][c + i] != 0)
                bomb(r, c + i, map);
            if (inRange(r - i, c) && map[r - i][c] != 0)
                bomb(r - i, c, map);
            if (inRange(r, c - i) && map[r][c - i] != 0)
                bomb(r, c - i, map);
        }
    }

    private void fallDown(int[][] map) {
        for (int i = 0; i < w; i++) {
            int idx = h - 1;
            int[] tmp = new int[h];
            for (int j = h - 1; j >= 0; j--) {
                if (map[j][i] == 0) continue;
                tmp[idx--] = map[j][i];
            }
            for (int j = 0; j < h; j++)
                map[j][i] = tmp[j];
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}
