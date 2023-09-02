package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12837 {
    int N, Q;
    long[] arr;
    long[] tree;

    /**
     * 가계부 (Hard)
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        tree = new long[4 * N + 1];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                update(1, 1, N, idx, val);
                arr[idx] += val;
            } else {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, s, e)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private void update(int node, int left, int right, int idx, long diff) {
        if (left > idx || right < idx) return;

        tree[node] += diff;
        if (left == right) return;

        int mid = (left + right) / 2;
        update(node * 2, left, mid, idx, diff);
        update(node * 2 + 1, mid + 1, right, idx, diff);
    }

    private long query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        long a = query(node * 2, left, mid, s, e);
        long b = query(node * 2 + 1, mid + 1, right, s, e);
        return a + b;
    }
}
