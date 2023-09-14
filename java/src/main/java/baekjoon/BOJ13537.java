package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13537 {
    int N, M;
    List<Integer>[] tree;
    /**
     * 수열과 쿼리 1
     * 세그먼트 트리와 이분탐색 문제
     * 세그먼트 트리를 List배열로 생성하여 각 구간에 포함 되는 원소를 저장 후 정렬
     * 이후 해당 구간에 속하면 이분탐색(정렬 되어 있으므로) K보다 최초로 커지는 idx를 구한다(upper bound).
     * K보다 큰 개수를 return 한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new List[4 * N];
        for (int i = 0; i < 4 * N; i++)
            tree[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            update(1, 0, N - 1, i, val);
        }
        for (int i = 0; i < 4 * N; i++)
            Collections.sort(tree[i]);
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());
            sb.append(query(1, 0, N - 1, l, r, k)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;

        tree[node].add(val);
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
    }

    private int query(int node, int s, int e, int l, int r, int k) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) {
            int idx = upperBound(tree[node], k);
            return tree[node].size() - idx;
        }

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r, k);
        int b = query(node * 2 + 1, mid + 1, e, l, r, k);
        return a + b;
    }

    private int upperBound(List<Integer> list, int k) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) <= k)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
}
