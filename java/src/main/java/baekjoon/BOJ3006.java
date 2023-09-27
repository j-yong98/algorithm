package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3006 {
    int N;
    int[] pos;
    int[] tree;

    /**
     * 터보 소트
     * 세그먼트 트리 풀이
     * N까지 1로 세그먼트 트리를 초기화 후
     * 실제 인덱스 기준으로 탐색하며 바꿔야될 횟수 계산
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pos = new int[N + 1];
        tree = new int[4 * N];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            pos[num] = i;
        }
        init(1, 1, N);
        int num1 = 1;
        int num2 = N;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) {
                sb.append(query(1, 1, N, 1, pos[num1] - 1)).append("\n");
                update(1, 1, N, pos[num1]);
                num1++;
            } else {
                sb.append(query(1, 1, N, pos[num2] + 1, N)).append("\n");
                update(1, 1, N, pos[num2]);
                num2--;
            }
        }
        System.out.println(sb);
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private void update(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;

        tree[node]--;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private int init(int node, int s, int e) {
        if (s == e) return tree[node] = 1;

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = a + b;
    }
}
