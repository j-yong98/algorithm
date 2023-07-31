package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {
    final int MAX = 100_000_000;
    int v, e;
    int start;
    List<Node>[] weights;

    /**
     * 최단경로
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        weights = new List[v + 1];
        for (int i = 1; i <= v; i++)
            weights[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            weights[a].add(new Node(b, c));
        }
        shortestPath();
    }


    private void shortestPath() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Arrays.fill(dist, MAX);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.idx])
                visited[node.idx] = true;

            for (Node next : weights[node.idx]) {
                if (visited[next.idx]) continue;
                if (node.weight + next.weight < dist[next.idx]) {
                    dist[next.idx] = node.weight + next.weight;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] >= MAX ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Node{
        int idx;
        int weight;
        public Node(int idx, int weight) {
            super();
            this.idx = idx;
            this.weight = weight;
        }
    }
}
