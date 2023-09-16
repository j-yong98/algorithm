package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10090 {
    int N;
    int[] arr;
    int[] tree;

    /**
     * Inversion Counting
     * 세그먼트 트리 풀이
     * 교차 선의 개수는 현재 자신 이으려고 하는 곳 보다 큰곳으로 연결한 작은 애들의 개수이다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += query(1, 0, N - 1, arr[i] + 1, N - 1);
            update(1, 0, N - 1, arr[i]);
        }
        System.out.println(ans);
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private void update(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;

        tree[node] += 1;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
