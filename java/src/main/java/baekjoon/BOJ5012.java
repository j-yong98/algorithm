package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5012 {
    final int MAX = 100_000;
    int N;
    int[] tree;
    long[] min;
    long[] max;
    Node[] arr;
    /**
     * 불만 정렬
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[4 * N];
        min = new long[N];
        max = new long[N];
        arr = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = new Node(val, i);
        }
        Arrays.sort(arr, (a, b) -> a.val == b.val ? Integer.compare(a.idx, b.idx) : Integer.compare(a.val, b.val));
        for (int i = 0; i < N; i++) {
            min[arr[i].idx] = query(1, 0, N - 1, arr[i].idx + 1, N - 1);
            update(1, 0, N - 1, arr[i].idx);
        }
        Arrays.fill(tree, 0);
        Arrays.sort(arr, (a, b) -> a.val == b.val ? Integer.compare(b.idx, a.idx) : Integer.compare(b.val, a.val));
        for (int i = 0; i < N; i++) {
            max[arr[i].idx] = query(1, 0, N - 1, 0, arr[i].idx - 1);
            update(1, 0, N - 1, arr[i].idx);
        }
        long ans = 0;
        for (int i = 0; i < N; i++)
            ans += min[i] * max[i];
        System.out.println(ans);
        br.close();
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


    static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
