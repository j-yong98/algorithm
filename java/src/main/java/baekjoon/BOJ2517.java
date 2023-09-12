package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2517 {
    int N;
    int[] tree;
    List<Node> arr;
    int[] cnt;

    /**
     * 달리기
     * 세그먼트 트리 풀이
     * 현재 자신보다 평소 실력이 작으면 내가 이길 수 있는 사람이기 때문에
     * 정렬 후 실제 인덱스 범위로 작은 숫자 개수 탐색
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        cnt = new int[N];
        tree = new int[4 * N + 1];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr.add(new Node(i, val));
        }
        Collections.sort(arr, (a, b) -> a.val - b.val);
        for (int i = 0; i < N; i++)
            arr.get(i).val = i;
        Collections.sort(arr, (a, b) -> a.idx - b.idx);
        for (int i = 0; i < N; i++) {
            cnt[arr.get(i).idx] = query(0, arr.get(i).val);
            update(1, 0, N - 1, arr.get(i).val);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(i - cnt[i] + 1).append("\n");
        System.out.print(sb);
        br.close();
    }

    private int update(int node, int left, int right, int idx) {
        if (idx > right || idx < left) return tree[node];

        tree[node] += 1;
        if (left == right) return tree[node];

        int mid = (left + right) >> 1;
        return tree[node] = update(node * 2, left, mid, idx) + update(node * 2 + 1, mid + 1, right, idx);
    }

    private int query(int s, int e) {
        return query(1, 0, N -  1, s, e);
    }

    private int query(int node, int left, int right, int s, int e) {
        if (s > right || e < left) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) >> 1;
        return query(node * 2, left, mid, s, e) + query(node * 2 + 1, mid + 1, right, s, e);
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
