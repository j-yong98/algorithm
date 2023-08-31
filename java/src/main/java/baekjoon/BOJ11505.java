package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11505 {
    final int MAX = 1_000_000;
    final int MOD = 1_000_000_007;
    int N, M, K;
    long[] arr = new long[MAX + 1];
    long[] tree = new long[4 * MAX + 1];
    /**
     * 구간 곱 구하기
     * 세그먼트 트리 문제
     * 누적곱으로 트리 구성
     * 이후 업데이트 시 해당 value를 교체 후 트리 재구성
     * 주의 사항 오버플로우
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        init(1, 0, N - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long val = Long.parseLong(st.nextToken());
                update(1, 0, N - 1, idx, val);
                arr[idx] = val;
            } else {
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(1, 0, N - 1, s, e)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
    private long update(int node, int left, int right, int idx, long num) {
        if (left > idx || right < idx) return tree[node];

        if (left == right) return tree[node] = num;

        int mid = (left + right) / 2;
        long a = update(node * 2, left, mid, idx, num);
        long b = update(node * 2 + 1, mid + 1, right, idx, num);
        return tree[node] = merge(a, b);
    }

    private long query(int node, int left, int right, int s, int e) {
        if (s > right || left > e) return 1;

        if (s <= left && right <= e) return tree[node];

        int mid = (left + right) / 2;
        long a = query(node * 2 , left, mid, s, e);
        long b = query(node * 2 + 1, mid + 1, right, s, e);
        return merge(a, b);
    }

    private long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        long a = init(node * 2, left, mid);
        long b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = merge(a, b);
    }

    private long merge(long a, long b) {
        return (a * b) % MOD;
    }
}
