package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ14497 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int N, M;
    char[][] arr;
    int[] junan;
    int[] criminal;
    int ans = 0;

    /**
     * 주난의 난(難)
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (i == 0)
                junan = new int[]{y, x};
            else
                criminal = new int[]{y, x};
        }
        arr = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++)
                arr[i][j] = line.charAt(j - 1);
        }
        while (arr[criminal[0]][criminal[1]] == '#') {
            ans++;
            jump(junan[0], junan[1]);
        }
        System.out.println(ans);
        br.close();
    }

    private void printMap() {
        for (int i = 1; i<= N; i++) {
            for (int j = 1; j <= M; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    private void jump(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][M + 1];

        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int yy = now[0] + dy[i];
                int xx = now[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx]) continue;
                visited[yy][xx] = true;
                if (arr[yy][xx] == '1' || arr[yy][xx] == '#') {
                    arr[yy][xx] = '0';
                    continue;
                }
                q.add(new int[]{yy, xx});
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= M;
    }
}
