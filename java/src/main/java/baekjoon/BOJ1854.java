package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1854 {
    int N, M, K;
    List<List<Node>> edges = new ArrayList<>();

    /**
     * K번째 최단 경로 찾기
     * 다익스트라 응용 풀이
     * 각 노드에 K개의 최단 간선을 저장 하는 방식
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
        }
        kDijkstra();
    }

    private void kDijkstra() {
        PriorityQueue<Node>[] dist = new PriorityQueue[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        for (int i = 1; i <= N; i++)
            dist[i] = new PriorityQueue<>((a, b) -> b.w - a.w);

        pq.add(new Node(1, 0));
        dist[1].add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : edges.get(now.v)) {
                Node node = new Node(next.v, now.w + next.w);
                if (dist[next.v].size() >= K) {
                    if (dist[next.v].peek().w <= next.w + now.w) continue;
                    dist[next.v].poll();
                }
                dist[next.v].add(node);
                pq.add(node);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i].size() < K)
                sb.append(-1);
            else
                sb.append(dist[i].poll().w);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
