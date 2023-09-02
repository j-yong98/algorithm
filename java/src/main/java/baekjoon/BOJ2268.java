package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2268 {
    int N, M;
    int[] arr;
    long[] tree;

    /**
     * 수들의 합 7
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new long[4 * N + 1];
        init(1, 1, N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sb.append(sum(1, 1, N, Math.min(s, e), Math.max(s, e))).append("\n");
            } else {
                int idx = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                modify(1, 1, N, idx, k - arr[idx]);
                arr[idx] = (int) k;
            }
        }
        System.out.print(sb);
    }

    private long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        return tree[node] = init(node * 2, left, mid) + init(node * 2 + 1, mid + 1, right);
    }

    private void modify(int node, int left, int right, int idx, long diff) {
        if (idx < left || idx > right) return;

        tree[node] += diff;
        if (left == right) return;

        int mid = (left + right) / 2;
        modify(node * 2, left, mid, idx, diff);
        modify(node * 2 + 1, mid + 1, right, idx, diff);
    }

    private long sum(int node, int left, int right, int s, int e) {
        if (left > e || s > right) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        long a = sum(node * 2, left, mid, s, e);
        long b = sum(node * 2 + 1, mid + 1, right, s, e);
        return a + b;
    }
}
