package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17135 {
    final int ENEMY = 1;
    int n, m;
    int d;
    int[][] arr;
    int[][] map;
    List<Integer> archers = new ArrayList<>();
    int ans = 0;
    private void initMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[i][j];
            }
        }
    }
    private boolean isFinish() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == ENEMY)
                    return false;
            }
        }
        return true;
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
    private void enemyMove() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == ENEMY && inRange(i + 1, j))
                    tmp[i + 1][j] = ENEMY;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }
    private int[] getMostCloseEnemy(int col) {
        int minDist = Integer.MAX_VALUE;
        int[] pos = {-1, -1};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == ENEMY) {
                    int dist = Math.abs(n - i) + Math.abs(col - j);
                    if (dist <= d) {
                        if (minDist > dist) {
                            minDist = dist;
                            pos[0] = i; pos[1] = j;
                        }
                        if (minDist == dist) {
                            if (pos[1] > j) {
                                pos[0] = i;
                                pos[1] = j;
                            }
                        }
                    }
                }
            }
        }
        return pos;
    }
    private int attack() {
        int cnt = 0;
        List<int[]> dieEnemy = new ArrayList<>();
        for (int i = 0; i < archers.size(); i++) {
            int archer = archers.get(i);
            int[] enemy = getMostCloseEnemy(archer);
            if (enemy[0] != -1 && enemy[1] != -1)
                dieEnemy.add(enemy);
        }
        for (int[] pos : dieEnemy) {
            if (map[pos[0]][pos[1]] != ENEMY)
                continue;
            map[pos[0]][pos[1]] = 0;
            cnt++;
        }
        return cnt;
    }
    private int start() {
        int kill = 0;
        initMap();
        while (!isFinish()) {
            kill += attack();
            enemyMove();
        }
        return kill;
    }
    private void selectCastle(int seq) {
        if (seq == m) {
            if (archers.size() == 3)
                ans = Math.max(ans, start());
            return ;
        }
        archers.add(seq);
        selectCastle(seq + 1);
        archers.remove(archers.size() - 1);
        selectCastle(seq + 1);
    }
    /**
     * 캐슬 디펜스
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selectCastle(0);
        System.out.println(ans);
    }
}
