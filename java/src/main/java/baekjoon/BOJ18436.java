package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18436 {
    int N, M;
    int[] arr;
    int[] oddTree;
    int[] evenTree;

    /**
     * 수열과 쿼리 37
     * 세그먼트 트리 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        oddTree = new int[4 * N + 1];
        evenTree = new int[4 * N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1, oddTree, 0);
        init(1, 0, N - 1, evenTree, 1);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                update(1, 0, N - 1, a, b, oddTree, 0);
                update(1, 0, N - 1, a, b, evenTree, 1);
            } else if (cmd == 2)
                sb.append(query(1, 0, N - 1, a, b - 1, evenTree)).append("\n");
            else
                sb.append(query(1, 0, N - 1, a, b - 1, oddTree)).append("\n");
        }
        System.out.print(sb);
    }

    private int query(int node, int left, int right, int s, int e, int[] tree) {
        if (right < s || e < left) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        int a = query(node * 2, left, mid, s, e, tree);
        int b = query(node * 2 + 1, mid + 1, right, s, e, tree);
        return merge(a, b);
    }

    private int update(int node, int left, int right, int idx, int val, int[] tree, int flag) {
        if (left > idx || right < idx) return tree[node];

        if (left == right) {
            arr[left] = val;
            int res = arr[left] % 2;
            if (flag == 0)
                tree[node] = res;
            else
                tree[node] = res ^ 1;
            return tree[node];
        }

        int mid = (left + right) / 2;
        int a = update(node * 2, left, mid, idx, val, tree, flag);
        int b = update(node * 2 + 1, mid + 1, right, idx, val, tree, flag);
        return tree[node] = merge(a, b);
    }

    private int init(int node, int left, int right, int[] tree, int flag) {
        if (left == right) {
            int res = arr[left] % 2;
            if (flag == 0)
                tree[node] = res;
            else
                tree[node] = res ^ 1;
            return tree[node];
        }

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid, tree, flag);
        int b = init(node * 2 + 1, mid + 1, right, tree, flag);
        return tree[node] = merge(a, b);
    }

    private int merge(int a, int b) {
        return a + b;
    }
}
