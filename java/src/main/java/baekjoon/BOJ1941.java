package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1941 {
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, -1, 1};
    final char YEON = 'Y';
    final int N = 5;
    char[][] arr = new char[N][N];
    boolean[] visited = new boolean[N * N];
    int ans = 0;

    List<int[]> list = new ArrayList<>();
    /**
     * 소문난 칠공주
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();
        backTracking(0, 0, 0);
        System.out.println(ans);
        br.close();
        return ans;
    }

    private void backTracking(int pick, int yCnt, int idx) {
        if (yCnt > 3) return;
        if (idx == N * N) {
            if (pick == 7 && check()) {
                ans++;
            }
            return;
        }
        int y = idx / N;
        int x = idx % N;

        visited[idx] = true;
        if (arr[y][x] == YEON) backTracking(pick + 1, yCnt + 1, idx + 1);
        else backTracking(pick + 1, yCnt, idx + 1);
        visited[idx] = false;
        backTracking(pick, yCnt, idx + 1);
    }

    private boolean check() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] checked = new boolean[N][N];
        int res = 0;
        for (int i = 0; i < N * N; i++) {
            if (!visited[i]) continue;
            q.add(new int[]{i / N, i % N});
            checked[i / N][i % N] = true;
            break;
        }

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            res++;
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + DY[i];
                int xx = pos[1] + DX[i];
                if (!inRange(yy, xx) || checked[yy][xx] || !visited[yy * N + xx]) continue;
                checked[yy][xx] = true;
                q.add(new int[]{yy, xx});
            }
        }

        if (res == 7) return true;
        return false;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
