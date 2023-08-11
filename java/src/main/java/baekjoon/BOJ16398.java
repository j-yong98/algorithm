package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16398 {
    int N;
    List<Node>[] nodes;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));

    /**
     * 행성 연결
     * 프림 알고리즘 사용
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nodes = new List[N + 1];
        for (int i = 0; i < N; i++)
            nodes[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                long w = Long.valueOf(st.nextToken());
                if (i == j) continue;
                nodes[i].add(new Node(i, j, w));
            }
        }
        long ans = prim();
        System.out.print(ans);
    }

    private long prim() {
        boolean[] visited = new boolean[N];
        visited[0] = true;
        for (int i = 0; i < nodes[0].size(); i++) pq.add(nodes[0].get(i));

        int count = 0;
        long res = 0;
        while (count < N - 1) {
            Node node = pq.poll();

            if (visited[node.v]) continue;

            visited[node.v] = true;
            count++;
            res += node.w;
            for (Node n : nodes[node.v])
                pq.add(n);
        }
        return res;
    }

    static class Node {
        int u;
        int v;
        long w;

        public Node(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
