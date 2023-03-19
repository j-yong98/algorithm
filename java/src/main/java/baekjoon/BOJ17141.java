package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17141 {
    final int CAN_VIRUS = 2;
    final int VIRUS = 3;
    int n, m;
    int[][] arr;
    int[][] dist;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    List<int[]> canVirusPos = new ArrayList<>();
    List<int[]> virusPos = new ArrayList<>();
    Queue<int[]> q = new LinkedList<>();
    int ans = Integer.MAX_VALUE;
    private void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }
    }
    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void spread() {
        for (int[] pos : virusPos) {
            dist[pos[0]][pos[1]] = 0;
            q.add(new int[]{pos[0], pos[1]});
        }
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && (arr[y][x] == 0 || arr[y][x] == 2) && dist[y][x] == -1) {
                    q.add(new int[]{y, x});
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                }
            }
        }
    }
    private void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] == - 1 ? "N " : dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private int getMinVal() {
        int val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && dist[i][j] == -1)
                    return Integer.MAX_VALUE;
                val = Math.max(val, dist[i][j]);
            }
        }
        return val;
    }
    private void putVirus(int seq) {
        if (seq == canVirusPos.size()) {
            if (virusPos.size() == m) {
                init();
                spread();
                ans = Math.min(ans, getMinVal());
            }
            return;
        }
        putVirus(seq + 1);
        virusPos.add(canVirusPos.get(seq));
        putVirus(seq + 1);
        virusPos.remove(virusPos.size() - 1);
    }
    /**
     * 연구소2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2)
                    canVirusPos.add(new int[]{i, j});
            }
        }
        putVirus(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
