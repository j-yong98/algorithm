package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12846 {
    int N;
    int[] arr;
    int[] minTree;

    /**
     * 무서운 아르바이트
     * 세그트리 + 분할정복
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        minTree = new int[4 * N];
        arr[N] = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        minInit(1, 0, N - 1);
        System.out.println(getMaxPay(0, N - 1));
    }

    private long getMaxPay(int left, int right) {
        if (left > right) return 0;
        int minIdx = minQuery(1, 0, N - 1, left, right);

        long res = (right - left + 1) * arr[minIdx];

        long a = getMaxPay(left, minIdx - 1);
        long b = getMaxPay(minIdx + 1, right);
        return Math.max(res, Math.max(a, b));
    }

    private int minQuery(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return N;

        if (s >= l && r >= e) return minTree[node];

        int mid = (s + e) >> 1;
        int a = minQuery(node * 2, s, mid, l, r);
        int b = minQuery(node * 2 + 1, mid + 1, e, l, r);
        return arr[a] > arr[b] ? b : a;
    }
    private int minInit(int node, int s, int e) {
        if (s == e) return minTree[node] = s;

        int mid = (s + e) >> 1;
        int a = minInit(node * 2, s, mid);
        int b = minInit(node * 2 + 1, mid + 1, e);
        return minTree[node] = arr[a] > arr[b] ? b : a;
    }
}
