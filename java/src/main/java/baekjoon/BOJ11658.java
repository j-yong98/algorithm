package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11658 {
    int N, M;
    int[][] arr;
    int[][] tree;

    /**
     * 구간 합 구하기 3
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        tree = new int[4 * N][4 * N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                updateY(1, 0, N - 1, i, j, arr[i][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            if (w == 0) {
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                updateY(1, 0, N - 1, y, x, c - arr[y][x]);
                arr[y][x] = c;
            } else {
                int y1 = Integer.parseInt(st.nextToken()) - 1;
                int x1 = Integer.parseInt(st.nextToken()) - 1;
                int y2 = Integer.parseInt(st.nextToken()) - 1;
                int x2 = Integer.parseInt(st.nextToken()) - 1;
                sb.append(queryY(1, 0, N - 1, y1, x1, y2, x2)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private int queryY(int node, int s, int e, int y1, int x1, int y2, int x2) {
        if (s > y2 || e < y1) return 0;

        if (s >= y1 && y2 >= e)
            return queryX(1, 0, N - 1, node, x1, x2);

        int mid = (s + e) >> 1;
        int a = queryY(node * 2, s, mid, y1, x1, y2, x2);
        int b = queryY(node * 2 + 1, mid + 1, e, y1, x1, y2, x2);
        return a + b;
    }

    private int queryX(int node, int s, int e, int y, int x1 ,int x2) {
        if (s > x2 || e < x1) return 0;

        if (s >= x1 && x2 >= e) return tree[y][node];

        int mid = (s + e) >> 1;
        int a = queryX(node * 2, s, mid, y, x1, x2);
        int b = queryX(node * 2 + 1, mid + 1, e, y, x1, x2);
        return a + b;
    }

    private void updateY(int node, int s, int e, int y, int x, int value) {
        if (s > y || e < y) return;

        if (s == e) {
            updateX(1, 0, N - 1, node, x, value);
            return;
        }
        int mid = (s + e) >> 1;
        updateY(node * 2, s, mid, y, x, value);
        updateY(node * 2 + 1, mid + 1, e, y, x, value);
        updateX(1, 0, N - 1, node, x, value);
    }

    private int updateX(int node, int s, int e, int y, int x, int value) {
        if (s > x || e < x) return tree[y][node];

        if (s == e) return tree[y][node] += value;

        int mid = (s + e) >> 1;
        int a = updateX(node * 2, s, mid, y, x, value);
        int b = updateX(node * 2 + 1, mid + 1, e, y, x, value);
        return tree[y][node] = a + b;
    }
}
