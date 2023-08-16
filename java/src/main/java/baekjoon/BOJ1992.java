package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
    int N;
    int[][] arr;
    StringBuilder sb = new StringBuilder();
    /**
     * 쿼드트리
     * 분할 정복
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                arr[i][j] = line.charAt(j) - '0';
        }
        br.close();
        quadTree(N, 0, 0);
        System.out.println(sb);
    }

    private void quadTree(int size, int y, int x) {
        if (size == 1) {
            sb.append(arr[y][x]);
            return;
        }
        if (allEqual(y, x, size)) {
            sb.append(arr[y][x]);
            return;
        }
        int next = size >> 1;
        sb.append("(");
        quadTree(next, y, x);
        quadTree(next, y, x + next);
        quadTree(next, y + next, x);
        quadTree(next, y + next, x + next);
        sb.append(")");
    }

    private boolean allEqual(int y, int x, int size) {
        int tmp = arr[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != tmp) return false;
            }
        }
        return true;
    }
}
