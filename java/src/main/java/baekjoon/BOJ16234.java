package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234 {
    int n, l, r;
    int cnt;
    int[][] map;
    int[][] check;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    List<int[]> union = new ArrayList<>();
    Deque<int[]> q = new ArrayDeque<>();
    int day = 0;

    private void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                check[i][j] = 0;
        }
        union.clear();
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private int calcUnion() {
        int sum = 0;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            sum += map[pos[0]][pos[1]];
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && check[y][x] == 0) {
                    int diff = Math.abs(map[pos[0]][pos[1]] - map[y][x]);
                    if (diff >= l && diff <= r) {
                        check[y][x] = 1;
                        q.addLast(new int[]{y, x});
                        union.add(new int[]{y, x});
                    }
                }
            }
        }
        for (int [] pos : union)
            map[pos[0]][pos[1]] = sum / union.size();
        return union.size() == 1 ? 0 : union.size();
    }
    private void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
    }
    /**
     * 인구 이동
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        check = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            cnt = 0;
            init();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j] == 0) {
                        union.clear();
                        check[i][j] = 1;
                        q.add(new int[]{i, j});
                        union.add(new int[]{i, j});
                        cnt += calcUnion();
                    }
                }
            }
            if (cnt == 0)
                break ;
            else day++;
        }
        System.out.println(day);
    }
}
