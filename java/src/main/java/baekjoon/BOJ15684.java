package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {
    int n, m, h;
    int[][] arr;
    int ans = Integer.MAX_VALUE;
    public boolean check(int[][] map, int r, int c) {
        for (int i = 1; i <= c; i++) {
            int y = 1, x = i;
            while (y <= r) {
                if (map[y][x] == 1) x++;
                else if (map[y][x - 1] == 1) x--;
                y++;
            }
            if (x != i)
                return false;
        }
        return true;
    }
    private void selectLines(int height, int cnt, int num) {
        if (cnt == num) {
            if (check(arr, h, n))
                ans = Math.min(ans, cnt);
            return ;
        }
        for (int i = height; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0 && arr[i][j + 1] == 0 && arr[i][j - 1] == 0) {
                    arr[i][j] = 1;
                    selectLines(i, cnt + 1, num);
                    arr[i][j] = 0;
                }
            }
        }
    }

    /**
     * 사다리 조작
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }
        for (int i = 0; i <= 3; i++)
            selectLines(1,0, i);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
