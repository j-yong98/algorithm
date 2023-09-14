package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14245 {
    int N, M;
    int[] arr;
    int[] tree;
    int[] lazy;

    /**
     *  XOR
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];
        lazy = new int[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, l, r, k);
            } else {
                int idx = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N - 1, idx)).append("\n");
            }
        }
        System.out.print(sb);
    }

    private int query(int node, int s, int e, int idx) {
        updateLazy(node, s, e);
        if (s > idx || e < idx) return 0;

        if (s == e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, idx);
        int b = query(node * 2 + 1, mid + 1, e, idx);
        return a ^ b;
    }

    private void updateLazy(int node, int s, int e) {
        if (lazy[node] == 0) return;
        tree[node] = ((e + s + 1) % 2) == 1 ? tree[node] ^ lazy[node] : tree[node];
        if (s != e) {
            lazy[node * 2] ^= lazy[node];
            lazy[node * 2 + 1] ^= lazy[node];
        }
        lazy[node] = 0;
    }

    private void update(int node, int s, int e, int l, int r, int k) {
        updateLazy(node, s, e);
        if (s > r || e < l) return;

        if (s >= l && r >= e) {
            tree[node] = (e - s + 1) % 2 == 1 ? tree[node] ^ k : tree[node];
            if (s != e) {
                lazy[node * 2] ^= k;
                lazy[node * 2 + 1] ^= k;
            }
            lazy[node] = 0;
            return;
        }

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, l, r, k);
        update(node * 2 + 1, mid + 1, e, l, r, k);
        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    private int init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = a ^ b;
    }
}
