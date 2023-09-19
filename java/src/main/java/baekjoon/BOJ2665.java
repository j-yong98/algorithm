package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2665 {
    final int BLACK = 0;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int N;
    int[][] arr;
    PriorityQueue<int[]> pq;
    boolean[][] visited;

    /**
     * 미로만들기
     * 너비 우선 탐색
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

        visited = new boolean[N][N];
        pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        visited[0][0] = true;
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == N - 1 && now[1] == N - 1) {
                System.out.println(now[2]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];

                if (!inRange(y, x) || visited[y][x]) continue;
                visited[y][x] = true;
                if (arr[y][x] == BLACK)
                    pq.add(new int[]{y, x, now[2] + 1});
                else
                    pq.add(new int[]{y, x, now[2]});
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
