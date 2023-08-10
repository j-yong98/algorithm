package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922 {
    int N, M;
    int[] table;
    PriorityQueue<Node> pq;
    int ans = 0;
    /**
     * 네트워크 연결
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        table = new int[N + 1];
        for (int i = 1; i <= N; i++)
            table[i] = i;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(u, v, w));
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (findParent(node.u) != findParent(node.v)) {
                ans += node.w;
                union(node.u, node.v);
            }
        }
        System.out.println(ans);
        br.close();
    }

    private int findParent(int a) {
        if (table[a] == a) return a;
        return findParent(table[a]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            if (p1 < p2)
                table[p2] = p1;
            else table[p1] = p2;
        }
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
