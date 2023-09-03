package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14427 {
    int N, M;
    int[] arr;
    int[] tree;
    /**
     * 수열과 쿼리 15
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N + 1];
        arr[0] = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 1, N);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                arr[idx] = val;
                update(1, 1, N, idx);
            } else
                sb.append(tree[1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int update(int node, int left, int right, int idx) {
        if (left > idx || right < idx) return tree[node];

        if (left == right) return idx;

        int mid = (left + right) / 2;
        int a = update(node * 2, left, mid, idx);
        int b = update(node * 2 + 1, mid + 1, right, idx);
        return tree[node] = merge(a, b);
    }

    private int init(int node, int left, int right) {
        if (left == right) return tree[node] = left;

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = merge(a, b);
    }

    private int merge(int a, int b) {
        if (arr[a] < arr[b])
            return a;
        else if (arr[a] == arr[b])
            return Math.min(a, b);
        else
            return b;
    }
}
