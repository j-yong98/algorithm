package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1719 {
    int N, M;
    List<List<Node>> edges = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    /**
     * 택비
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
            edges.get(u).add(new Node(u, v, w));
            edges.get(v).add(new Node(v, u, w));
        }
        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        System.out.println(sb);
        br.close();
    }

    private void dijkstra(int start) {
        int[] dist = new int[N + 1];
        int[] path = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.v] < now.w) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] >= dist[next.v]) continue;
                path[next.v] = now.v;
                dist[next.v] = dist[now.v] + next.w;
                path[next.v] = now.v;
                pq.add(new Node(now.v, next.v, dist[next.v]));
            }
        }
        trace(path, start);
    }

    private void trace(int[] path, int start) {
        for (int i = 1; i <= N; i++) {
            if (i == start) sb.append("- ");
            else {
                int a = 0;
                for (int j = i; j != start; j = path[j]) {
                    a = j;
                }
                sb.append(a).append(" ");
            }
        }
        sb.append("\n");
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
    }
}
