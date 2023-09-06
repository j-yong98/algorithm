package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ16948 {
    int[] dy = {-2, -2, 0, 0, 2, 2};
    int[] dx = {-1, 1, -2, 2, -1, 1};
    int N;
    int[] pos;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(bfs());
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        visited[pos[0]][pos[1]] = true;
        q.add(new int[]{pos[0], pos[1], 0});

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == pos[2] && now[1] == pos[3]) return now[2];

            for (int i = 0; i < 6; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (!inRange(y, x) || visited[y][x]) continue;
                visited[y][x] = true;
                q.add(new int[]{y, x, now[2] + 1});
            }
        }
        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
