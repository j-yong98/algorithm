package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11085 {
    int P, W;
    int C, V;
    PriorityQueue<Node> edges = new PriorityQueue<>((a, b) -> b.w - a.w);
    int[] parent;
    /**
     * 군사 이동
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        parent = new int[P];
        for (int i = 0; i < P; i++)
            parent[i] = i;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Node(u, v, w));
        }
        while (!edges.isEmpty()) {
            Node now = edges.poll();

            union(now.u, now.v);
            if (findParent(C) == findParent(V)) {
                System.out.println(now.w);
                return;
            }
        }
        br.close();
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2)
            parent[p2] = p1;
    }

    private int findParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
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
