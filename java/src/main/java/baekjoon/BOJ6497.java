package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6497 {
    int N, M;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
    int[] table;

    /**
     * 전력난
     * 크루스칼 알고리즘 사용
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            table = new int[N + 1];
            for (int i = 1; i <= N; i++)
                table[i] = i;
            int sum = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.add(new Node(u, v, w));
                sum += w;
            }
            int ans = 0;
            ans = kruskal(ans);
            sb.append(sum - ans).append("\n");
        }
        System.out.print(sb);
    }

    private int kruskal(int ans) {
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (findParent(node.u) != findParent(node.v)) {
                union(node.u, node.v);
                ans += node.w;
            }
        }
        return ans;
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
            else
                table[p1] = p2;
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
