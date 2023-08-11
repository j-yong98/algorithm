package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14621 {
    int N, M;
    List<Node>[] edges;
    boolean[] boyGirl;

    /**
     * 나만 안되는 연애
     * 프림 알고리즘 사용
     * 간선이 같은 여자거나 남자를 잇는 간선이면 제외
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boyGirl = new boolean[N + 1];
        edges = new List[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str = st.nextToken();
            boyGirl[i] = str.equals("M");
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (boyGirl[u] == boyGirl[v]) continue;
            edges[u].add(new Node(u, v, w));
            edges[v].add(new Node(v, u, w));
        }
        System.out.println(prim());
    }

    private int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (edges[i].size() == 0) continue;
            for (int j = 0; j < edges[i].size(); j++)
                pq.add(edges[i].get(j));
            visited[i] = true;
            break;
        }

        int count = 0;
        int res = 0;
        while (!pq.isEmpty() && count < N - 1) {
            Node node = pq.poll();

            if (visited[node.v]) continue;

            visited[node.v] = true;
            count++;
            res += node.w;
            for (Node n : edges[node.v])
                pq.add(n);
        }
        if (count == N - 1)
            return res;
        return -1;
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
