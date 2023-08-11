package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21924 {
    int N, M;
    List<Node>[] nodes;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));

    /**
     * 도시 건설
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new List[N + 1];
        for (int i = 1; i <= N; i++)
            nodes[i] = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Integer.parseInt(st.nextToken());
            nodes[u].add(new Node(u, v, w));
            nodes[v].add(new Node(v, u, w));
            sum += w;
        }
        long ans = prim();
        if (ans == -1)
            System.out.println(ans);
        else
            System.out.print(sum - ans);
    }

    private long prim() {
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            for (int j = 0; j < nodes[i].size(); j++) {
                flag = true;
                pq.add(nodes[i].get(j));
            }
            if (flag) break;
        }

        int count = 0;
        long res = 0;
        while (count < N - 1 && !pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.v]) continue;

            visited[node.v] = true;
            count++;
            res += node.w;
            for (Node n : nodes[node.v])
                pq.add(n);
        }
        if (count != N - 1) return -1;
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
