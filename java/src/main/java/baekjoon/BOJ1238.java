package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1238 {
    final int MAX = 100_000_000;
    int n, m, x;
    List<Node>[] nodes;
    int ans = 0;

    /**
     * 파티
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        nodes = new List[n + 1];
        for (int i = 1; i <= n; i++)
            nodes[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
        }
        for (int i = 1; i <= n; i++) {
            int b = getDist(i, x) + getDist(x, i);
            ans = Math.max(ans, b);
        }
        System.out.println(ans);
    }

    private int getDist(int start, int goal) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node n : nodes[now.idx]) {
                if (n.weight + dist[now.idx] < dist[n.idx]) {
                    dist[n.idx] = n.weight + dist[now.idx];
                    pq.add(new Node(n.idx, now.weight + dist[n.idx]));
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
