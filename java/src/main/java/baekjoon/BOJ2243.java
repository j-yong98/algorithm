package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2243 {
    final int MAX = 10;
    int N;
    long[] tree = new long[4 * MAX + 1];
    /**
     * 사탕 상자
     * 세그먼트 트리 K번째 수 찾는 문제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int res = query(1, 1, MAX, idx);
                sb.append(res).append("\n");
            } else {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                update(1, 1, MAX, idx, val);
            }
        }
        System.out.print(sb);
        br.close();
    }

    private int query(int node, int left, int right, long val) {
        if (left == right) {
            tree[node] -= 1;
            return left;
        }
        int res;
        int mid = (left + right) >> 1;
        if (val <= tree[node * 2]) res = query(node * 2, left, mid, val);
        else res = query(node * 2 + 1, mid + 1, right, val - tree[node * 2]);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return res;
    }

    private long update(int node, int left, int right, int idx, int val) {
        if (left > idx || idx > right) return tree[node];

        tree[node] += val;
        if (left == right)
            return tree[node];

        int mid = (left + right) >> 1;
        return tree[node] = update(node * 2, left, mid, idx, val) + update(node * 2 + 1, mid + 1, right, idx, val);
    }
}
