package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1615 {
    int N, M;
    List<List<Integer>> edges = new ArrayList<>();
    int[] tree;
    /**
     * 교차 개수 구하기
     * inversionCounting && 세그먼트 트리
     * 교차선의 개수는 현재 자신의 값보다 뒤에 값들이 작은 애들의 합이다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        tree = new int[4 * N + 1];
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            edges.get(a).add(b);
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int b : edges.get(i)) {
                ans += query(1, 1, N, b + 1, N);
                update(1, 1, N, b);
            }
        }
        System.out.println(ans);
        br.close();
    }

    private int query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) >> 1;
        return query(node * 2, left, mid, s, e) + query(node * 2 + 1, mid + 1, right, s, e);
    }

    private int update(int node, int left, int right, int idx) {
        if (idx > right || idx < left) return tree[node];

        tree[node] += 1;
        if (left == right) return tree[node];

        int mid = (left + right) >> 1;
        return tree[node] = update(node * 2, left, mid, idx) + update(node * 2 + 1, mid + 1, right, idx);
    }
}
