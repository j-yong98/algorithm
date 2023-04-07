package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15685 {
    int n;
    int[][] arr = new int[101][101];
    int[] dy = {0, -1, 0, 1};
    int[] dx = {1, 0, -1, 0};
    private void dragonCurve(int x, int y, int d, int g) {
        List<Integer> dir = new ArrayList<>();
        dir.add(d);
        for (int i = 1; i <= g; i++) {
            for (int j = dir.size() - 1; j >= 0; j--)
                dir.add((dir.get(j) + 1) % 4);
        }
        arr[y][x] = 1;
        for (Integer r : dir) {
            y += dy[r];
            x += dx[r];
            arr[y][x] = 1;
        }
    }
    /**
     * 드래곤 커브
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }
        int cnt = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i + 1][j] == 1 && arr[i + 1][j + 1] == 1)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
