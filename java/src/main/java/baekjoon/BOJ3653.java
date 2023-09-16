package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3653 {
    int T, N, M;
    int[] idx;
    int[] tree;

    /**
     * 영화 수집
     * 배열의 크기를 M + N 개만큼 잡은 후 쿼리를 수행해 맨 앞으로 오는애를 배열 앞부분에 배치하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            idx = new int[N];
            tree = new int[4 * (N + M)];
            for (int i = 0; i < N; i++) {
                idx[i] = i + M;
                update(1, 0, (N + M) - 1, idx[i], 1);
            }
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(1, 0, (N + M) - 1, 0, idx[num] - 1)).append(" ");
                update(1, 0, (N + M) - 1, idx[num], -1);
                idx[num] = M - i - 1;
                update(1, 0, (N + M) - 1, idx[num], 1);
            }
            System.out.println(sb);
        }
    }

    private void update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;

        tree[node] += val;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }
}
