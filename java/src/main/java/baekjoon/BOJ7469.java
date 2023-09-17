package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ7469 {
    int N, M;
    List<Integer>[] tree;
    List<Integer> seg;
    /**
     * K번째 수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new List[4 * N];
        for (int i = 0; i < 4 * N; i++)
            tree[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            update(1, 0, N - 1, i, val);
        }
        for (int i = 0; i < 4 * N; i++)
            Collections.sort(tree[i]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            seg = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            query(1, 0, N - 1, l, r);
            Collections.sort(seg);
            sb.append(seg.get(k)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return;

        if (s >= l && r >= e) {
            for (int i = 0; i < tree[node].size(); i++)
                seg.add(tree[node].get(i));
            return;
        }

        int mid = (s + e) >> 1;
        query(node * 2, s, mid, l, r);
        query(node * 2 + 1, mid + 1, e, l, r);
    }

    private void update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;

        tree[node].add(val);
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
    }
}
