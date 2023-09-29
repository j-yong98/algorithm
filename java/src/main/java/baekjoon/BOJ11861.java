package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11861 {
    int N;
    int[] arr;
    int[] minTree;
    /**
     * Maximal Area
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
        init(1, 0, N - 1);
        System.out.println(getMaximalSurface(0, N - 1));
        br.close();
    }

    private long getMaximalSurface(int s, int e) {
        if (s > e) return 0;

        int length = (e - s) + 1;
        int idx = query(1, 0, N - 1, s, e);

        long res = length * (long) arr[idx];

        long a = getMaximalSurface(s, idx - 1);
        long b = getMaximalSurface(idx + 1, e);
        return Math.max(res, Math.max(a, b));
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return N;

        if (s >= l && r >= e) return minTree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return merge(a, b);
    }

    private int init(int node, int s, int e) {
        if (s == e) return minTree[node] = s;

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return minTree[node] = merge(a, b);
    }

    private int merge(int a, int b) {
        if (arr[a] == arr[b]) return Math.min(a, b);
        return arr[a] < arr[b] ? a : b;
    }
}
