package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6218 {
    int N, Q;
    int[] arr;
    int[] minTree;
    int[] maxTree;

    /**
     * Balanced Lineup
     * 세그먼트 트리 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        minTree = new int[4 * N + 1];
        maxTree = new int[4 * N + 1];
        minTree[0] = Integer.MAX_VALUE;
        maxTree[0] = Integer.MIN_VALUE;
        init(1, 0, N - 1, minTree, 0);
        init(1, 0, N - 1, maxTree, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int a = query(1, 0, N - 1, s, e, minTree,0);
            int b = query(1, 0, N - 1, s, e, maxTree,1);
            sb.append(b - a).append("\n");
        }
        System.out.print(sb);
    }

    private int query(int node, int left, int right, int s, int e, int[] tree,int flag) {
        if (left > e || right < s) return tree[0];

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        int a = query(node * 2, left, mid, s, e, tree, flag);
        int b = query(node * 2 + 1, mid + 1, right, s, e, tree, flag);
        return merge(a, b, flag);
    }

    private int init(int node, int left, int right, int[] tree, int flag) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid, tree, flag);
        int b = init(node * 2 + 1, mid + 1, right, tree, flag);
        return tree[node] = merge(a, b, flag);
    }

    private int merge(int a, int b, int flag) {
        if (flag == 0)
            return Math.min(a, b);
        return Math.max(a, b);
    }

}
