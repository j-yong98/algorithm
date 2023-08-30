package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1865 {
    final int MAX = 1_000_000_000;
    int T;
    int N, M, W;
    List<List<Node>> edges;

    /**
     * 웜홀
     * 벨만포드 문제(최단 거리 음수 간선)
     * 음수 간선을 확인하기 위해 노든 간선을 확인한 V - 1번째에도 최단 거리의 갱신이 일어 난다면 사이클
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.get(s).add(new Node(e, w));
                edges.get(e).add(new Node(s, w));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.get(s).add(new Node(e, -w));
            }
            boolean res = false;
            for (int i = 1; i <= N; i++) {
                res = bellmanford(i);
                if (res) {
                    sb.append("YES").append("\n");
                    break;
                }
            }
            if (!res) sb.append("NO").append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private boolean bellmanford(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);

        dist[start] = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 1; j <= N; j++) {
                for (Node next : edges.get(j)) {
                    if (dist[j] != MAX && dist[next.v] > dist[j] + next.w) {
                        dist[next.v] = dist[j] + next.w;

                        flag = true;
                        if (i == N - 1) return true;
                    }
                }
            }
            if (!flag) break;
        }

        return false;
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
