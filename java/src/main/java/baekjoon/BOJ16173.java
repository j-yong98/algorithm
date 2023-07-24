package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ16173 {
    int n;
    int[][] arr;
    boolean[][] visited;
    int[] DY = { 1, 0 };
    int[] DX = { 0, 1 };

    /**
     * 점프왕 쩰리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String ans = "Hing";
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            if (pos[0] == n - 1 && pos[1] == n - 1) {
                ans = "HaruHaru";
                break;
            }
            for (int i = 0; i < 2; i++) {
                int y = pos[0] + DY[i] * arr[pos[0]][pos[1]];
                int x = pos[1] + DX[i] * arr[pos[0]][pos[1]];
                if (inRange(y, x) && !visited[y][x]) {
                    q.add(new int[] {y, x});
                    visited[y][x] = true;
                }
            }
        }
        System.out.println(ans);
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
