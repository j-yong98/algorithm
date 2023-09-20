package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5719 {
    int N, M;
    List<List<Node>> edges;
    List<Node>[] minPath;
    int S, E;

    /**
     * 거의 최단 경로
     * 다익스트라 풀이
     * 최단 경로를 구한 뒤
     * 해당 경로를 제거 하고 다음 최단 경로를 구해준다.
     * 도착지에 못가는 경우와 함께 최단경로가 여러개인 점을 감안해서 구현 해야 한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            for (int i = 0; i < N; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.get(u).add(new Node(u, v, w));
            }
            int res = dijkstra();
            if (res == -1) {
                sb.append(-1).append("\n");
            } else {
                removePath(E);
                sb.append(dijkstra()).append("\n");
            }
        }
        System.out.print(sb);
    }

    private void removePath(int e) {
        if (e == S) return;
        for (Node prev : minPath[e]) {
            List<Node> edge = edges.get(prev.u);
            for (int i = edge.size() - 1; i >= 0; i--) {
                if (edge.get(i).equals(prev)) {
                    removePath(edge.get(i).u);
                    edges.get(prev.u).remove(edge.get(i));
                }
            }
        }
    }

    private int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        minPath = new List[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(S, S, 0));
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] < dist[next.v]) {
                    dist[next.v] = next.w + dist[now.v];
                    pq.add(new Node(now.v, next.v, dist[next.v]));
                    minPath[next.v] = new ArrayList<>();
                    minPath[next.v].add(new Node(now.v, next.v, next.w));
                } else if (next.w + dist[now.v] == dist[next.v])
                    minPath[next.v].add(new Node(now.v, next.v, next.w));
            }
        }
        return dist[E] == Integer.MAX_VALUE ? -1 : dist[E];
    }

    static class Node {
        int u;
        int v;
        int w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return u == node.u && v == node.v && w == node.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v, w);
        }
    }
}
