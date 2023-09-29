package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14463 {
    int N;
    int[] arr;
    int[] tree;
    /**
     * 소가 길을 건너간 이유 9
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        Arrays.fill(arr, -1);
        tree = new int[2 * N * 4];
        long ans = 0;
        for (int i = 0; i < 2 * N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (arr[num] == -1) {
                arr[num] = i;
                update(1, 0, 2 * N, i, 1);
            } else {
                ans += query(1, 0, 2 * N, arr[num] + 1, i);
                update(1, 0, 2 * N, arr[num], 0);
            }
        }
        System.out.println(ans);
        br.close();
    }

    private int update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return tree[node];

        if (s == e) return tree[node] = val;

        int mid = (s + e) >> 1;
        int a = update(node * 2, s, mid, idx, val);
        int b = update(node * 2 + 1, mid + 1, e, idx, val);
        return tree[node] = a + b;
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2  + 1, mid + 1, e, l, r);
        return a + b;
    }
}
