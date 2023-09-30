package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15967 {
    int N, Q1, Q2;
    int[] arr;
    long[] tree;
    long[] lazy;

    /**
     * 에바쿰
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q2 = Integer.parseInt(st.nextToken());
        Q1 = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new long[4 * N];
        lazy = new long[4 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 1, N);
        for (int i = 0; i < Q1 + Q2; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (cmd == 1)
                System.out.println(query(1, 1, N, l, r));
            else {
                long val = Integer.parseInt(st.nextToken());
                update(1, 1, N, l, r, val);
            }
        }
        br.close();
    }

    private void update(int node, int s, int e, int l, int r, long val) {
        updateLazy(node, s, e);
        if (s > r || e < l) return;

        if (s >= l && r >= e) {
            tree[node] += ((long) e - (long) s + 1) * val;
            if (s != e) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return;
        }

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, l, r, val);
        update(node * 2 + 1, mid + 1, e, l, r, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private long query(int node, int s, int e, int l, int r) {
        updateLazy(node, s, e);
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        long a = query(node * 2, s, mid, l, r);
        long b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private void updateLazy(int node, int s, int e) {
        if (lazy[node] != 0) {
            tree[node] += ((long) e - (long) s + 1) * lazy[node];
            if (s != e) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private long init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];

        int mid = (s + e) >> 1;
        long a = init(node * 2, s, mid);
        long b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = a + b;
    }
}
