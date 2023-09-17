package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1395 {
    int N, M;
    int[] tree;
    boolean[] lazy;
    /**
     * 스위치
     * 느리게 갱신 하는 세그먼트 트리 풀이
     * 현재 자신의 스위치 반전 개수는 구간의 개수 - 켜져 있는 개수로 풀이 된다.
     * 또한 스위치를 2번 반전하는 것은 원래와 같은 상태이기 때문에 아래 자식의 lazy를 저장할 때는 반전값을 저장한다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[4 * N + 1];
        lazy = new boolean[4 * N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (cmd == 0)
                update(1, 1, N, l, r);
            else
                sb.append(query(1, 1, N, l, r)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void update(int node, int s, int e, int l, int r) {
        updateLazy(node, s, e);
        if (s > r || e < l) return;

        if (s >= l && r >= e) {
            tree[node] = (e - s + 1) - tree[node];
            if (s != e) {
                lazy[node * 2] = !lazy[node * 2];
                lazy[node * 2 + 1] = !lazy[node * 2 + 1];
            }
            lazy[node] = false;
            return;
        }

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, l, r);
        update(node * 2 + 1, mid + 1, e, l, r);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private int query(int node, int s, int e, int l, int r) {
        updateLazy(node, s, e);
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return a + b;
    }

    private void updateLazy(int node, int s, int e) {
        if (!lazy[node]) return;
        tree[node] = (e - s + 1) - tree[node];
        if (s != e) {
            lazy[node * 2] = !lazy[node * 2];
            lazy[node * 2 + 1] = !lazy[node * 2 + 1];
        }
        lazy[node] = false;
    }
}
