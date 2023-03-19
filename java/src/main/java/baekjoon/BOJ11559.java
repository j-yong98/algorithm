package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11559 {
    final int EXPLODE = 4;
    final int ROW = 12;
    final int COL = 6;
    char[][] map = new char[ROW][COL];
    int[][] visited = new int[ROW][COL];
    List<int[]> bomb = new ArrayList<>();
    boolean bFlag;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    int chain = 0;
    private boolean inRange(int y, int x) {
        return y >= 0 && y < ROW && x >= 0 && x < COL;
    }
    private void initVisited() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                visited[i][j] = 0;
            }
        }
    }
    private void cntPuyo(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx) && visited[yy][xx] == 0 && map[y][x] == map[yy][xx]) {
                visited[yy][xx] = 1;
                bomb.add(new int[]{yy, xx});
                cntPuyo(yy, xx);
            }
        }
    }
    private void init(char[] tmp) {
        for (int i = 0; i < ROW; i++)
            tmp[i] = '.';
    }
    private void drop() {
        for (int i = 0; i < COL; i++) {
            char[] tmp = new char[ROW];
            init(tmp);
            int idx = ROW - 1;
            for (int j = ROW - 1; j >= 0; j--) {
                if (map[j][i] == '.')
                    continue;
                tmp[idx--] = map[j][i];
            }
            for (int j = 0; j < ROW; j++)
                map[j][i] = tmp[j];
        }
    }
    private void printMap() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    private void explodePuyo() {
        for (int[] pos : bomb) {
            map[pos[0]][pos[1]] = '.';
        }
    }
    private void check() {
        bFlag = false;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == '.')
                    continue ;
                initVisited();
                bomb.clear();
                visited[i][j] = 1;
                bomb.add(new int[]{i, j});
                cntPuyo(i, j);
                if (bomb.size() >= EXPLODE) {
                    explodePuyo();
                    bFlag = true;
                }
            }
        }
        if (bFlag) {
            chain++;
            drop();
            check();
        }
    }
    /**
     * Puyo Puyo
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ROW; i++) {
            String r = br.readLine();
            for (int j = 0; j < COL; j++) {
                map[i][j] = r.charAt(j);
            }
        }
        check();
        System.out.println(chain);
    }
}
