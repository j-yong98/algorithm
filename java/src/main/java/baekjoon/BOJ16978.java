package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16978 {
    int N, Q;
    int[] arr;
    long[] tree;
    Deque<int[]> u = new ArrayDeque<>();
    List<int[]> q = new ArrayList<>();
    long[] ans;

    /**
     * 수열과 쿼리 22
     * 세그먼트 트리, 오프라인 쿼리 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new long[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 1, N);
        int len = 0;
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                u.offerLast(new int[]{idx, val});
            } else {
                int k = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                q.add(new int[]{k, s, e, len++});
            }
        }
        ans = new long[len];
        Collections.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0, repeat = 0; i < q.size();) {
            int[] qq = q.get(i);
            if (qq[0] == repeat) {
                ans[qq[3]] = query(1, 1, N, qq[1], qq[2]);
                i++;
            }
            else {
                while (qq[0] > repeat) {
                    repeat++;
                    int[] uu = u.pollFirst();
                    update(1, 1, N, uu[0], uu[1] - arr[uu[0]]);
                    arr[uu[0]] = uu[1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(ans[i]).append("\n");
        System.out.print(sb);
    }

    private long update(int node, int left, int right, int idx, int val) {
        if (idx < left || idx > right) return tree[node];

        tree[node] += val;
        if (left == right) return tree[node];

        int mid = (left + right) >> 1;
        long a = update(node * 2, left, mid, idx, val);
        long b = update(node * 2 + 1, mid + 1, right, idx, val);
        return tree[node] = a + b;
    }

    private long query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) >> 1;
        long a = query(node * 2, left, mid, s, e);
        long b = query(node * 2 + 1, mid + 1, right, s, e);
        return a + b;
    }

    private long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) >> 1;
        long a = init(node * 2, left, mid);
        long b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = a + b;
    }
}
