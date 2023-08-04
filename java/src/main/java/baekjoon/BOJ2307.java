package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2307 {
    final int MAX = Integer.MAX_VALUE;
    final int EMPTY = -1;
    int N, M;
    int[][] edges;
    int[] path;
    int removePath;

    /**
     * 도로 검문
     * 도착지에 최단 거리로 가는 경로를 저장 해놓고 해당 경로를 하나씩 삭제하며 재탐색
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(edges[i], EMPTY);
        path = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u][v] = w;
            edges[v][u] = w;
        }
        int minPath = dijkstra(true);
        removePath = Integer.MIN_VALUE;
        checkRoad(N);
        System.out.println(removePath == Integer.MAX_VALUE ? -1 : removePath - minPath);
        br.close();
    }

    private int dijkstra(boolean check) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, MAX);
        pq.add(new int[]{1, 0});
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (!visited[now[0]]) visited[now[0]] = true;


            for (int i = 1; i <= N; i++) {
                if (edges[now[0]][i] == EMPTY) continue;
                if (!visited[i] && edges[now[0]][i] + now[1] < dist[i]) {
                    dist[i] = edges[now[0]][i] + now[1];
                    pq.add(new int[]{i, dist[i]});
                    if (check) path[i] = now[0];
                }
            }
        }
        return dist[N];
    }

    private void checkRoad(int now) {
        if (now == 1) return;

        int tmp = edges[path[now]][now];

        edges[path[now]][now] = EMPTY;
        edges[now][path[now]] = EMPTY;

        removePath = Math.max(removePath, dijkstra(false));

        edges[path[now]][now] = tmp;
        edges[now][path[now]] = tmp;

        checkRoad(path[now]);
    }
}
