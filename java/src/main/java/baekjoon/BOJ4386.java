package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4386 {
    int N;
    List<double[]> pos = new ArrayList<>();
    List<List<Node>> edges = new ArrayList<>();

    /**
     * 별자리 만들기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double y = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            pos.add(new double[]{y, x});
            edges.add(new ArrayList<>());
        }
        makeGraph();
        prim();
        br.close();
    }

    private void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(a.w, b.w));
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (edges.get(i).isEmpty()) continue;
            pq.addAll(edges.get(i));
            visited[i] = true;
            break;
        }

        int cnt = 0;
        double w = 0;
        while (!pq.isEmpty() && cnt < N - 1) {
            Node now = pq.poll();

            if (visited[now.v]) continue;

            visited[now.v] = true;
            cnt += 1;
            w += now.w;
            for (Node next : edges.get(now.v)) {
                if (visited[next.v]) continue;
                pq.add(next);
            }
        }
        System.out.println(String.format("%.2f", w));
    }

    private void makeGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = getDist(pos.get(i)[0], pos.get(i)[1], pos.get(j)[0], pos.get(j)[1]);
                edges.get(i).add(new Node(j, dist));
                edges.get(j).add(new Node(i, dist));
            }
        }
    }

    private double getDist(double y1, double x1, double y2, double x2) {
        return Math.sqrt(Math.pow(Math.abs(y1 - y2), 2) + Math.pow(Math.abs(x1 - x2), 2));
    }

    static class Node {
        int v;
        double w;

        public Node(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }
}
