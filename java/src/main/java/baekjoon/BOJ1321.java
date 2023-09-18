package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1321 {
    int N, M;
    int[] arr;
    int[] tree;

    /**
     * 군인
     * K번째 찾는 세그먼트 트리를 활용한 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                update(1, 1, N, idx, cnt);
            } else {
                int k = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, k)).append("\n");
            }
        }
        System.out.print(sb);
    }

    private int query(int node, int s, int e, int k) {
        if (s == e) return s;

        int mid = (s + e) >> 1;
        int res;
        if (tree[node * 2] >= k) res = query(node * 2, s, mid, k);
        else res = query(node * 2 + 1, mid + 1, e, k - tree[node * 2]);
        return res;
    }

    private void update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;

        tree[node] += val;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
    }

    private int init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = a + b;
    }
}
