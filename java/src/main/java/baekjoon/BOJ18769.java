package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18769 {
    int T;
    int R, C;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.w - b.w);
    int[] parents;

    /**
     * 그리디 네트워크
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            parents = new int[R * C];
            for (int i = 0; i < R * C; i++)
                parents[i] = i;
            int idx = 0;
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C - 1; j++) {
                    int u = idx;
                    int v = u + 1;
                    int w = Integer.parseInt(st.nextToken());
                    idx++;
                    pq.add(new Node(u, v, w));
                }
                idx++;
            }
            idx = 0;
            for (int i = 0; i < R - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    int u = idx;
                    int v = idx + C;
                    int w = Integer.parseInt(st.nextToken());
                    idx++;
                    pq.add(new Node(u, v, w));
                }
            }
            int res = kruskal();
            System.out.println(res);
        }
    }

    private int kruskal() {
        int res = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (findParent(now.u) != findParent(now.v)) {
                union(now.u, now.v);
                res += now.w;
            }
        }
        return res;
    }

    private int findParent(int a) {
        if (a == parents[a]) return a;
        return findParent(parents[a]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            if (p1 < p2)
                parents[p2] = p1;
            else
                parents[p1] = p2;
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
