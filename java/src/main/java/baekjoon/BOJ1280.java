package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1280 {
    final int MAX = 200_000;
    final int MOD = 1_000_000_007;
    int N;
    long[] sumTree = new long[4 * MAX];
    int[] countTree = new int[4 * MAX];
    int[] arr;

    /**
     * 나무 심기
     * 세그먼트 트리 활용 풀이
     * 각 위치로 세그먼트 트리를 구성 후
     * 현재 위치보다 작은 개수 * x - 작은 것들의 합
     * 현재 위치보다 큰 애들의 합 - 개수 * x
     * 의 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        long ans = 1;
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                long a = (((long) countQuery(1, 0, MAX, 0, arr[i] - 1) * arr[i]) - sumQuery(1, 0, MAX, 0, arr[i] - 1)) % MOD;
                long b = (sumQuery(1, 0, MAX, arr[i] + 1, MAX) - ((long) countQuery(1, 0, MAX, arr[i] + 1, MAX) * arr[i])) % MOD;
                ans = (ans * (a + b)) % MOD;
            }
            countUpdate(1, 0, MAX, arr[i]);
            sumUpdate(1, 0, MAX, arr[i]);
        }
        System.out.println(ans);
    }

    private void sumUpdate(int node, int s, int e, int val) {
        if (s > val || e < val) return;

        sumTree[node] += val;
        if (s == e) return;

        int mid = (s + e) >> 1;
        sumUpdate(node * 2, s, mid, val);
        sumUpdate(node * 2 + 1, mid + 1, e, val);
    }

    private void countUpdate(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;

        countTree[node] += 1;
        if (s == e) return;

        int mid = (s + e) >> 1;
        countUpdate(node * 2, s, mid, idx);
        countUpdate(node * 2 + 1, mid + 1, e, idx);
    }
    private long sumQuery(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return sumTree[node];
        int mid = (s + e) >> 1;
        long a = sumQuery(node * 2, s, mid, l, r);
        long b = sumQuery(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private int countQuery(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return countTree[node];

        int mid = (s + e) >> 1;
        int a = countQuery(node * 2, s, mid, l, r);
        int b = countQuery(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }
}
