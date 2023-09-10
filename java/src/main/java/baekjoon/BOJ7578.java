package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7578 {
    final int MAX = 500;
    int N;
    List<List<Integer>> edges = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    long[] tree = new long[4 * MAX + 1];
    /**
     * 공장
     * 세그먼트 트리
     * inversion Counting 유형
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            map.put(val, i);
        }
        for (int i = 0; i  < N; i++)
            edges.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            int idx = map.get(val);
            edges.get(idx).add(i);
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            if (edges.get(i).isEmpty()) continue;
            for (int edge : edges.get(i)) {
                ans += query(1, 0, N - 1, edge + 1, N - 1);
                update(1, 0, N - 1, edge);
            }
        }
        System.out.println(ans);
        br.close();
    }

    private long query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) >> 1;
        long a = query(node * 2, left, mid, s, e);
        long b = query(node * 2 + 1, mid + 1, right, s, e);
        return a + b;
    }

    private long update(int node, int left, int right, int idx) {
        if (left > idx || right < idx) return tree[node];

        tree[node] += 1;
        if (left == right) return tree[node];

        int mid = (left + right) >> 1;
        long a = update(node * 2, left, mid, idx);
        long b = update(node * 2 + 1, mid + 1, right, idx);
        return tree[node] = a + b;
    }
}
