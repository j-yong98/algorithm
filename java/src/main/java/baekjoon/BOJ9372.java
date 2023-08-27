package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9372 {
    int T;
    int N, M;
    List<Node> edges;
    int[] parent;
    /**
     * 상근이의 여행
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++)
                parent[i] = i;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.add(new Node(a, b, 1));
            }
            Collections.sort(edges, (a, b) -> a.w - b.w);
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                Node now = edges.get(i);

                if (findParent(now.u) != findParent(now.v)) {
                    union(now.u, now.v);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    private int findParent(int a) {
        if (a == parent[a]) return a;
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
