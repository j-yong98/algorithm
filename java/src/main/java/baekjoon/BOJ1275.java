package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1275 {
    int N, Q;
    long[] arr;
    long[] tree;

    /**
     * 커피숍2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[4 * N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            sb.append(query(1, 0, N - 1, x, y)).append("\n");
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());
            update(1, 0, N - 1, a, b - arr[a]);
            arr[a] = b;
        }
        System.out.print(sb);
    }

    private long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        long a = init(node * 2, left, mid);
        long b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = merge(a, b);
    }

    private void update(int node, int left, int right, int idx, long diff) {
        if (left > idx || idx > right) return;

        tree[node] += diff;
        if (left == right) return;

        int mid = (left + right) / 2;
        update(node * 2, left, mid, idx, diff);
        update(node * 2 + 1, mid + 1, right, idx, diff);
    }

    private long query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && right <= e) return tree[node];

        int mid = (left + right) / 2;
        long a = query(node * 2, left, mid, s, e);
        long b = query(node * 2 + 1, mid + 1, right, s, e);
        return merge(a, b);
    }

    private long merge(long a, long b) {
        return a + b;
    }
}
