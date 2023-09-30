package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14727 {
    int N;
    int[] arr;
    int[] tree;
    /**
     * 퍼즐 자르기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        arr[N] = Integer.MAX_VALUE;
        init(1, 0, N - 1);
        System.out.println(getMaxArea(0, N - 1));
        br.close();
    }

    private long getMaxArea(int s, int e) {
        if (s > e) return 0;

        int idx = query(1, 0, N - 1, s, e);
        long res = (long) arr[idx] * (e - s + 1);

        long a = getMaxArea(s, idx - 1);
        long b = getMaxArea(idx + 1, e);
        return Math.max(res, Math.max(a, b));
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return N;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return merge(a, b);
    }

    private int init(int node, int s, int e) {
        if (s == e) return tree[node] = s;

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = merge(a, b);
    }

    private int merge(int a, int b) {
        if (arr[a] == arr[b]) return a;
        return arr[a] < arr[b] ? a : b;
    }
}
