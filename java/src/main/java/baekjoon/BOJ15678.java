package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15678 {
    int N, D;
    int[] arr;
    long[] tree;
    long[] dp;
    /**
     * 연세워터파크
     * 세그트리와 DP를 이용한 최댓값 저장
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new long[N + 1];
        tree = new long[4 * N];
        arr[0] = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            dp[i] = Math.max(dp[i], arr[i] + query(1, 1, N, Math.max(1, i - D), i - 1));
            update(1, 1, N, i, dp[i]);
        }
        System.out.println(Arrays.stream(dp, 1, N + 1).max().getAsLong());
        br.close();
    }

    private void update(int node, int s, int e, int idx, long val) {
        if (s == e) {
            tree[node] = val;
            return;
        }

        int mid = (s + e) >> 1;
        if (idx <= mid)
            update(node * 2, s, mid, idx, val);
        else
            update(node * 2 + 1, mid + 1, e, idx, val);
        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    private long query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return Integer.MIN_VALUE;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        long a = query(node * 2, s, mid, l, r);
        long b = query(node * 2 + 1, mid + 1, e, l, r);
        return Math.max(a, b);
    }
}
