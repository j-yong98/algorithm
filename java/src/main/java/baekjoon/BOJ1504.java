package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1504 {
    final int MAX = 200_000_000;
    int n, m;
    int v1, v2;
    List<Node>[] nodes;
    int ans = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new List[n + 1];
        for (int i = 1; i <= n; i++)
            nodes[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[u].add(new Node(v, c));
            nodes[v].add(new Node(u, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        ans = Math.min(getDist(1, v1) + getDist(v1, v2) + getDist(v2, n),
                getDist(1, v2) + getDist(v2, v1) + getDist(v1, n));
        System.out.println(ans >= MAX ? -1 : ans);
    }

    private int getDist(int start, int goal) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, MAX);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.idx]) {
                visited[now.idx] = true;

                for (Node n : nodes[now.idx]) {
                    if (visited[n.idx])
                        continue;
                    if (n.weight + dist[now.idx] < dist[n.idx]) {
                        dist[n.idx] = n.weight + dist[now.idx];
                        pq.add(new Node(n.idx, dist[n.idx]));
                    }
                }
            }
        }
        return dist[goal];
    }

    class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}
