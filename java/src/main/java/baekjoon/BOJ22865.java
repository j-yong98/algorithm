package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ22865 {
    int N, M;
    List<Integer> abc = new ArrayList<>();
    List<Node>[] edges;
    int[][] dist;

    /**
     * 가장 먼 곳
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[3][N + 1];
        edges = new List[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            abc.add(Integer.parseInt(st.nextToken()));

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Node(v, w));
            edges[v].add(new Node(u, w));
        }
        for (int i = 0; i < 3; i++)
            dist[i] = dijkstra(abc.get(i));
        int ans = 0;
        int pos = -1;
        for (int i = 1; i <= N; i++) {
            if (abc.contains(i)) continue;
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < 3; j++) {
                if (min > dist[j][i]) {
                    min = dist[j][i];
                    idx = i;
                }
            }
            if (ans < min) {
                ans = min;
                pos = idx;
            } else if (ans == min)
                pos = Math.min(pos, idx);
        }
        System.out.println(pos);
    }

    private int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.u]) continue;

            for (Node next : edges[now.u]) {
                if (next.w + now.w < dist[next.u]) {
                    dist[next.u] = now.w + next.w;
                    pq.add(new Node(next.u, dist[next.u]));
                }
            }
        }
        return dist;
    }
    class Node {
        int u;
        int w;

        public Node(int u, int w) {
            this.u = u;
            this.w = w;
        }
    }
}
