package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1944 {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int WALL = -1;
    final int BLANK = 0;
    int N, M;
    int[][] arr;
    boolean[] checked;
    List<Edge>[] graph;

    /**
     * 복제 로봇
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        checked = new boolean[M + 2];
        graph = new List[M + 2];
        for (int i = 1; i <= M + 1; i++)
            graph[i] = new ArrayList<>();
        int idx = 2;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == '0') arr[i][j] = BLANK;
                else if (c == 'S') arr[i][j] = 1;
                else if (c == '1') arr[i][j] = WALL;
                else arr[i][j] = idx++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != WALL && arr[i][j] != BLANK)
                    bfs(i, j);
            }
        }
        prim();
    }

    private void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int res = 0;
        boolean[] visited = new boolean[M + 2];
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.v]) continue;
            visited[now.v] = true;
            res += now.w;

            for (Edge next : graph[now.v]) {
                if (visited[next.v]) continue;
                pq.add(next);
            }
        }
        boolean flag = true;
        for (int i = 1; i <= M + 1; i++) {
            if (visited[i]) continue;
            flag = false;
            break;
        }
        if (!flag)
            System.out.println(-1);
        else
            System.out.println(res);
    }

    private void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;
        checked[arr[y][x]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || arr[yy][xx] == WALL) continue;
                if (arr[yy][xx] != BLANK && !checked[arr[yy][xx]]) {
                    graph[arr[y][x]].add(new Edge(arr[yy][xx], pos[2] + 1));
                    graph[arr[yy][xx]].add(new Edge(arr[y][x], pos[2] + 1));
                }
                visited[yy][xx] = true;
                q.add(new int[]{yy, xx, pos[2] + 1});
            }
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
