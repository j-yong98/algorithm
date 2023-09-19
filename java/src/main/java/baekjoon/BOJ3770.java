package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3770 {
    int T;
    int N, M, K;
    int[] tree;
    List<List<Integer>> edges;
    /**
     * 대한민국
     * 세그먼트 트리를 활용한 Inversion Counting 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            tree = new int[4 * M + 1];
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
            }
            long ans = 0;
            for (int i = 1; i <= N; i++) {
                if (edges.get(i).isEmpty()) continue;
                Collections.sort(edges.get(i));
                for (int west : edges.get(i)) {
                    int res = query(1, 1, M, west + 1, M);
                    ans += res;
                    update(1, 1, M, west);
                }
            }
            sb.append("Test case ").append(t + 1).append(": ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void update(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;

        tree[node] += 1;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }
}
