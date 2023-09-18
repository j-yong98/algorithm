package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1306 {
    int N, M;
    int[] arr;
    int[] tree;

    /**
     * 최댓값 세그먼트 트리를 이용한 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new int[4 * N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N - M + 1; i++) {
            sb.append(query(1, 1, N, i - (M - 1), i + (M - 1))).append(" ");
        }
        System.out.println(sb);
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return Math.max(a, b);
    }

    private int init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = Math.max(a, b);
    }
}
