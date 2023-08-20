package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17086 {
    final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    final int SHARK = 1;
    int N, M;
    int[][] arr;
    int[][] count;
    List<int[]> sharks = new ArrayList<>();

    /**
     * 아기 상어 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        count = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == SHARK)
                    sharks.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < N; i++)
            Arrays.fill(count[i], Integer.MAX_VALUE);
        System.out.println(getMaxSafeZone());
        br.close();
    }

    private int getMaxSafeZone() {
        for (int[] shark : sharks)
            bfs(shark);
        return Arrays.stream(count).flatMapToInt(Arrays::stream).max().getAsInt();
    }

    private void bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        q.add(start);
        visited[start[0]][start[1]] = true;
        count[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            for (int i = 0; i < 8; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || count[yy][xx] < count[pos[0]][pos[1]] + 1) continue;
                count[yy][xx] = count[pos[0]][pos[1]] + 1;
                q.add(new int[]{yy, xx});
                visited[yy][xx] = true;
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
