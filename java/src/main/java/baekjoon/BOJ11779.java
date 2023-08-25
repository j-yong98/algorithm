package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11779 {
    final int MAX = 100_000_000;
    int V, E;
    int START;
    int END;
    List<List<Node>> edges = new ArrayList<>();
    List<Integer> shortestPath = new ArrayList<>();

    /**
     * 최소비용 구하기2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append(dijikstra()).append("\n");
        sb.append(shortestPath.size()).append("\n");
        for (int i = shortestPath.size() - 1; i >= 0; i--)
            sb.append(shortestPath.get(i)).append(" ");
        System.out.println(sb);
        br.close();
    }

    private int dijikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dist = new int[V + 1];
        int[] path = new int[V + 1];

        Arrays.fill(dist, MAX);

        pq.add(new Node(START, 0));
        dist[START] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] >= dist[next.v]) continue;
                dist[next.v] = next.w + dist[now.v];
                path[next.v] = now.v;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
        int now = END;
        while (now != START) {
            shortestPath.add(now);
            now = path[now];
        }
        shortestPath.add(START);
        return dist[END];
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
