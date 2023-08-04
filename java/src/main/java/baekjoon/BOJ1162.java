package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1162 {
    final long MAX = Long.MAX_VALUE;
    int N, M, K;
    List<Node>[] edges;

    /**
     * 도로 포장
     * 도로를 최대 K개 포장 (가중치가 0)으로 했을 때 최단 거리
     * pq에 넣을 때 k에 대한 정보도 같이 넣어 계산
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        edges = new List[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Node(v, w, 0));
            edges[v].add(new Node(u, w, 0));
        }
        System.out.println(dijkstra());
        br.close();
    }

    private long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        long[][] dist = new long[N + 1][K + 1];

        for (int i = 1; i <= N; i++)
            Arrays.fill(dist[i], MAX);
        pq.add(new Node(1, 0, 0));
        Arrays.fill(dist[1], 0);

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.u][now.k]) continue;

            for (Node next : edges[now.u]) {
                if (next.w + now.w < dist[next.u][now.k]) {
                    dist[next.u][now.k] = next.w + now.w;
                    pq.add(new Node(next.u, dist[next.u][now.k], now.k));

                    if (next.w != 0 && now.k < K && dist[next.u][now.k + 1] > dist[next.u][now.k] - next.w) {
                        dist[next.u][now.k + 1] = dist[next.u][now.k] - next.w;
                        pq.add(new Node(next.u, dist[next.u][now.k + 1], now.k + 1));
                    }
                }
            }
        }
        return Arrays.stream(dist[N]).min().getAsLong();
    }

    static class Node {
        int u;
        long w;
        int k;

        public Node(int u, long w, int k) {
            this.u = u;
            this.w = w;
            this.k = k;
        }
    }
}
