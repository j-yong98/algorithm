package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem116 {
    int T;
    int n, m;
    char[][] arr;

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    private boolean bfs() {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != '?')
                    q.add(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            char ch = arr[pos[0]][pos[1]];
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x))
                    continue;
                if (ch == arr[y][x])
                    return false;
                if (arr[y][x] != '?')
                    continue;
                arr[y][x] = arr[pos[0]][pos[1]] == '#' ? '.' : '#';
                q.add(new int[]{y, x});
            }
        }
        return true;
    }

    /**
     * 격자판 칠하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                char[] str = br.readLine().toCharArray();
                arr[i] = str;
            }
            System.out.println("#" + t + " " + (bfs() ? "possible" : "impossible"));
        }
    }
}
