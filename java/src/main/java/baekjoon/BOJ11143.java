package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11143 {
    int T;
    int B;
    int P;
    int Q;
    long[] arr;
    long[] tree;

    /**
     * Beads
     * 세그먼트 트리 유형
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            B = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            arr = new long[B];
            tree = new long[4 * B + 1];
            for (int i = 0; i < P + Q; i++) {
                String[] line = br.readLine().split(" ");
                if (line[0].equals("P")) {
                    int idx = Integer.parseInt(line[1]) - 1;
                    long val = Long.parseLong(line[2]);
                    update(1, 0, B - 1, idx, val);
                    arr[idx] += val;
                } else {
                    int s = Integer.parseInt(line[1]) - 1;
                    int e = Integer.parseInt(line[2]) - 1;
                    sb.append(query(1, 0, B - 1, s, e)).append("\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    private long update(int node, int left, int right, int idx, long diff) {
        if (left > idx || right < idx) return tree[node];

        tree[node] += diff;
        if (left == right) return tree[node];

        int mid = (left + right) / 2;
        long a = update(node * 2, left, mid, idx, diff);
        long b = update(node * 2 + 1, mid + 1, right, idx, diff);
        return tree[node] = merge(a, b);
    }

    private long query(int node, int left, int right, int s, int e) {
        if (left > e || s > right) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        long a = query(node * 2, left, mid, s, e);
        long b = query(node * 2 + 1, mid + 1, right, s, e);
        return merge(a, b);
    }
    private long merge(long a, long b) {
        return a + b;
    }
}
