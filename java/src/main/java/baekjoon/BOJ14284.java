package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14284 {
    int N, M;
    List<List<Node>> edges = new ArrayList<>();
    int S, T;

    /**
     * 간선 이어가기 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra());
    }

    private int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(S, 0));
        dist[S] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] >= dist[next.v]) continue;
                dist[next.v] = dist[now.v] + next.w;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
        return dist[T];
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
