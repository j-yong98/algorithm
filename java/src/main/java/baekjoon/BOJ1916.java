package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    int N, M;
    List<Node>[] edges;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Integer.parseInt(st.nextToken());
            edges[u].add(new Node(v, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(a, b));
    }

    private long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.u] < now.w) continue;

            for (Node next : edges[now.u]) {
                if (now.w + next.w < dist[next.u]) {
                    dist[next.u] = now.w + next.w;
                    pq.add(new Node(next.u, dist[next.u]));
                }
            }
        }
        return dist[end];
    }

    static class Node {
        int u;
        long w;

        public Node(int u, long w) {
            this.u = u;
            this.w = w;
        }
    }
}
