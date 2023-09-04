package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1168 {
    int N, K;
    int[] tree;

    /**
     * 요세푸스 문제 2
     * 세그트리를 이용한 풀이
     * 현재 요소의 개수를 나타내는 세그트리 구성 후
     * 출력 해야하는 요소를 출력 후 재구성
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new int[4 * N + 1];
        init(1, 1, N);
        sb.append("<");
        int k = K;
        for (int i = 0; i < N; i++) {
            int res = query(1, 1, N, k);
            sb.append(res).append(", ");
            if (i == N - 1) continue;
            k = (k + K - 1) % tree[1];
            if (k == 0) k = tree[1];
        }
        sb.append(">");
        sb.delete(sb.length() - 3, sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    private int query(int node, int left, int right, int k) {
        if (left == right) {
            tree[node] -= 1;
            return left;
        }
        int res;
        int mid = (left + right) / 2;
        if (tree[node * 2] >= k) res = query(node * 2, left, mid, k);
        else res = query(node * 2 + 1, mid + 1, right, k - tree[node * 2]);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return res;
    }

    private int init(int node, int left, int right) {
        if (left == right) return tree[node] = 1;

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = a + b;
    }
}
