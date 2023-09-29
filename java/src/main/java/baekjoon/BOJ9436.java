package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9436 {
    int T;
    int N;
    int[] tree;
    int[] arr;
    /**
     * 순열 그래프
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            tree = new int[4 * N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int idx = Integer.parseInt(st.nextToken());
                arr[idx] = i;
            }
            long ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int idx = Integer.parseInt(st.nextToken());
                ans += query(1, 1, N, arr[idx], N);
                update(1, 1, N, arr[idx]);
            }
            sb.append(ans).append("\n");
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
