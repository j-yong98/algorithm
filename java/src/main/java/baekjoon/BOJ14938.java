package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14938 {
    final int MAX = 100_000_000;
    int N, M, R;
    int[] items;
    List<List<Node>> edges = new ArrayList<>();

    /**
     * 서강 그라운드
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        int ans = 0;
        for (int i = 1; i <= N; i++)
            ans = Math.max(ans, dijikstra(i));
        System.out.println(ans);
        br.close();
    }

    private int dijikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dist = new int[N + 1];

        Arrays.fill(dist, MAX);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] >= dist[next.v]) continue;
                if (next.w + dist[now.v] > M) continue;
                dist[next.v] = next.w + dist[now.v];
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == MAX) continue;
            res += items[i];
        }
        return res;
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
