package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17406 {
    int n, m, k;
    int[][] origin;
    int[][] arr;
    int[][] tmp;
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    int[][] info;
    int[] per;
    int[] visited;
    int ans = Integer.MAX_VALUE;
    private boolean cmp(int[] s, int[] e) {
        return s[0] == e[0] && s[1] == e[1];
    }

    private boolean inRange(int y, int x, int[] start, int[] end) {
        return y >= start[0] && y <= end[0] && x >= start[1] && x <= end[1];
    }

    private void copy(int[][] dst, int[][] src) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                dst[i][j] = src[i][j];
        }
    }

    private void calc(int[] start, int[] end) {
        int dir = 0;
        int y = start[0];
        int x = start[1];
        copy(tmp, arr);
        while (dir < 4) {
            int yy = y + dy[dir];
            int xx = x + dx[dir];
            if (!inRange(yy, xx, start, end)) {
                dir++;
                continue;
            }
            tmp[yy][xx] = arr[y][x];
            y = yy;
            x = xx;
        }
        copy(arr, tmp);
    }

    private void rotate(int r, int c, int s) {
        int[] start = {r - s, c - s};
        int[] end = {r + s, c + s};
        while (!cmp(start, end)) {
            calc(start, end);
            start[0] += 1;
            start[1] += 1;
            end[0] -= 1;
            end[1] -= 1;
        }
    }

    private void printArray() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    private int getMinRow() {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = Arrays.stream(arr[i]).sum();
            res = Math.min(res, sum);
        }
        return res;
    }
    private void selectRotate(int seq) {
        if (seq == k) {
            copy(arr, origin);
            for (int i = 0; i < k; i++)
                rotate(info[per[i]][0], info[per[i]][1], info[per[i]][2]);
            ans = Math.min(ans, getMinRow());
            return ;
        }
        for (int i = 0; i < k; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                per[seq] = i;
                selectRotate(seq + 1);
                visited[i] = 0;
            }
        }
    }
    /**
     * 배열 돌리기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        origin = new int[n + 1][m + 1];
        arr = new int[n + 1][m + 1];
        tmp = new int[n + 1][m + 1];
        info = new int[k][3];
        per = new int[k];
        visited = new int[k];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++)
                origin[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            info[i] = new int[]{r, c, s};
        }
        selectRotate(0);
        System.out.println(ans);
    }
}
