package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9426 {
    int N, K;
    final int MAX = 1 << 16;
    int[] arr;
    int[] tree = new int[4 * MAX];

    /**
     * 중앙값 측정
     * 세그먼트 트리 풀이
     * 세그먼트 트리를 들어간 개수로 1~MAX까지 구간의 합의 개수로 풀이
     * 이후 K개 이상이 되면 중앙값 찾고 제일 왼쪽요소 제거 후 다음 수 넣어 길이가 K가 되도록 고정
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            update(1, 0, MAX, arr[i], 1);
            if (i - K < 0) continue;
            ans += query(1, 0, MAX, (K + 1) >> 1);
            update(1, 0, MAX, arr[(i - K) + 1], -1);
        }
        System.out.println(ans);
        br.close();
    }

    private int update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return tree[node];

        tree[node] += val;
        if (s == e) return tree[node];

        int mid = (s + e) >> 1;
        int a = update(node * 2, s, mid, idx, val);
        int b = update(node * 2 + 1, mid + 1, e, idx, val);
        return tree[node] = a + b;
    }

    private int query(int node, int s, int e, int k) {
        if (s == e) return s;

        int res;
        int mid = (s + e) >> 1;
        if (tree[node * 2] >= k) res = query(node * 2, s, mid, k);
        else res = query(node * 2 + 1, mid + 1, e, k - tree[node * 2]);
        return res;
    }
}
