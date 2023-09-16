package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16975 {
    int N, M;
    int[] arr;
    long[] tree;
    long[] lazy;
    StringBuilder sb = new StringBuilder();

    /**
     * 수열과 쿼리 21
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new long[4 * N];
        lazy = new long[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                long d = Long.parseLong(st.nextToken());
                update(1, 0, N - 1, b, c, d);
            } else {
                int b = Integer.parseInt(st.nextToken()) - 1;
                query(1, 0, N - 1, b);
            }
        }
        System.out.print(sb);
        br.close();
    }

    private void update(int node, int left, int right, int s, int e, long val) {
        updateLazy(node, left, right);
        if (left > e || s > right) return;

        if (left >= s && e >= right) {
            tree[node] += (right - left + 1) * val;
            if (left != right) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            lazy[node] = 0;
            return;
        }

        int mid = (left + right) >> 1;
        update(node * 2, left, mid, s, e, val);
        update(node * 2 + 1, mid + 1, right, s, e, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private void updateLazy(int node, int left, int right) {
        if (lazy[node] != 0) {
            tree[node] += (right - left + 1) * lazy[node];
            if (left != right) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private void query(int node, int left, int right, int idx) {
        updateLazy(node, left, right);
        if (left > idx || right < idx) return;

        if (left == right) {
            sb.append(tree[node]).append("\n");
            return;
        }
        int mid = (left + right) >> 1;
        query(node * 2, left, mid, idx);
        query(node * 2 + 1, mid + 1, right, idx);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) >> 1;
        long a = init(node * 2, left, mid);
        long b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = a + b;
    }
}
