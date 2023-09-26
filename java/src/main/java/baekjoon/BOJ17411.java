package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17411 {
    int MOD = 1_000_000_007;
    int N;
    Count[] tree;
    Node[] arr;
    int[] cnt;

    /**
     * 가장 긴 증가하는 부분 수열 6
     * 가장 긴 증가하는 부분 수열이 되는 개수를 세는 문제
     * 가장 긴 수열의 개수는 해당 길이의 -1의 될 수 있는 갯수이다.
     * i를 가장 긴 증가하는 부분 수열의 길이라고 한다면
     * i = 모든 i - 1의 합이 된다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        cnt = new int[N];
        tree = new Count[4 * N];
        tree[0] = new Count(0, 0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = new Node(i, val);
        }
        init(1, 0, N);
        Arrays.sort(arr, (a, b) -> a.val == b.val ? b.idx - a.idx : Integer.compare(a.val, b.val));
        for (int i = 0; i < N; i++) {
            Count c = query(1, 0, N, 0, arr[i].idx);
            Count res = new Count(c.value + 1, Math.max(c.cnt,1));
            update(1, 0, N, arr[i].idx, res);
        }
        System.out.println(tree[1].value + " " + tree[1].cnt);
    }

    private Count init(int node, int s, int e) {
        if (s == e) return tree[node] = new Count(0, 0);

        int mid = (s + e) >> 1;
        Count a = init(node * 2, s, mid);
        Count b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = merge(a, b);
    }

    private Count query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return tree[0];

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        Count a = query(node * 2, s, mid, l, r);
        Count b = query(node * 2 + 1, mid + 1, e, l, r);
        return merge(a, b);
    }

    private Count update(int node, int s, int e, int idx, Count c) {
        if (s > idx || e < idx) return tree[node];

        if (s == e)
            return tree[node] = merge(tree[node], c);

        int mid = (s + e) >> 1;
        Count a = update(node * 2, s, mid, idx, c);
        Count b = update(node * 2 + 1, mid + 1, e, idx, c);
        return tree[node] = merge(a, b);
    }

    private Count merge(Count a, Count b) {
        if (a.value == b.value) return new Count(a.value, (a.cnt + b.cnt) % MOD);
        return a.value > b.value ? a : b;
    }
    static class Count {
        int value;
        int cnt;

        public Count(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }

    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
