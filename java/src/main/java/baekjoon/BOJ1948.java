package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1948 {
    int N, M;
    List<Node>[] edges;
    List<Node>[] reverseEdges;
    int[] count;
    int[] dist;
    boolean[] visited;
    int ans = 0;
    /**
     * 임계경로
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        reverseEdges = new List[N + 1];
        count = new int[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            reverseEdges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Node(v, w));
            reverseEdges[v].add(new Node(u, w));
            count[v]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        findPath(s);
        System.out.println(dist[e]);
        findPathCount(e);
        System.out.println(ans);
        br.close();
    }

    private void findPath(int s) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer now = q.pollFirst();

            for (Node n : edges[now]) {
                if (--count[n.v] == 0)
                    q.add(n.v);
                dist[n.v] = Math.max(dist[n.v], dist[now] + n.w);
            }
        }
    }

    private void findPathCount(int e) {
        if (visited[e]) return;
        visited[e] = true;

        for (Node n : reverseEdges[e]) {
            if (dist[e] - n.w == dist[n.v]) {
                ans++;
                findPathCount(n.v);
            }
        }
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
