package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14438 {
    int N, M;
    int[] arr;
    int[] tree;

    /**
     * 수열과 쿼리 17
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        tree = new int[4 * N + 1];
        init(1, 1, N);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 2) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, s, e)).append("\n");
            } else {
                int idx = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                arr[idx] = k;
                modify(1, 1, N, idx);
            }
        }
        System.out.print(sb);
    }

    private int init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = merge(a, b);
    }

    private int modify(int node, int left, int right, int idx) {
        if (idx < left || idx > right) return tree[node];

        if (left == right) return tree[node] = arr[idx];

        int mid = (left + right) / 2;
        int a = modify(node * 2, left, mid, idx);
        int b = modify(node * 2 + 1, mid + 1, right, idx);
        return tree[node] = merge(a, b);
    }

    private int query(int node, int left, int right, int s, int e) {
        if (left > e || s > right) return Integer.MAX_VALUE;

        if (s <= left && right <= e) return tree[node];

        int mid = (left + right) / 2;
        int a = query(node * 2, left, mid, s, e);
        int b = query(node * 2 + 1, mid + 1, right, s, e);
        return merge(a, b);
    }

    private int merge(int a, int b) {
        return Math.min(a, b);
    }
}
