package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10868 {
    final int MAX = 100_000;
    int N, M;
    int[] arr = new int[MAX + 1];
    int[] minTree = new int[4 * MAX + 1];
    int[] maxTree = new int[4 * MAX + 1];

    /**
     * 최솟값 구하기
     * 세그먼트 트리를 이용하여 최솟값 트리 구성
     * 구간 최솟값 출력
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arrays.fill(maxTree, Integer.MIN_VALUE);
        Arrays.fill(minTree, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        init(1, 1, N, minTree, 0);
        init(1, 1, N, maxTree, 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(query(1, 1, N, a, b, minTree, 0)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int init(int node, int left, int right, int[] tree, int flag) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid, tree, flag);
        int b = init(node * 2 + 1, mid + 1, right, tree, flag);
        return tree[node] = merge(a, b, flag);
    }

    private int query(int node, int left, int right, int s, int e, int[] tree, int flag) {
        if (right < s || left > e) return tree[0];

        if (s <= left && right <= e) return tree[node];

        int mid = (left + right) / 2;

        int a = query(node * 2, left, mid, s, e, tree, flag);
        int b = query(node * 2 + 1, mid + 1, right, s, e, tree, flag);
        return merge(a, b, flag);
    }

    private int merge(int a, int b, int flag) {
        if (flag > 0)
            return Math.max(a, b);
        return Math.min(a, b);
    }
}
