package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9345 {
    int T;
    int N, K;
    Node[] tree;
    int[] arr;

    /**
     * 디지털 비디오 디스크
     * 세그먼트 트리 풀이
     * 구간의 최소값과 최댓값을 설정해 놓고
     * 해당 범위에서 벗어난다면 false return
     * update시 각 구간의 숫자만 있다면 숫자가 바껴도 상관 없기 때문에
     * 구간의 최솟값과 최댓값으로 판단
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            tree = new Node[4 * N];
            arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = i;
            init(1, 0, N - 1);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (cmd == 0) {
                    arr[l] ^= arr[r];
                    arr[r] ^= arr[l];
                    arr[l] ^= arr[r];
                    update(1, 0, N - 1, l);
                    update(1, 0, N - 1, r);
                }
                else
                    sb.append(query(1, 0, N - 1, l, r) ? "YES\n" : "NO\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private boolean query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return true;

        if (s >= l && r >= e) {
            return !(tree[node].min < l || tree[node].max > r);
        }

        int mid = (s + e) >> 1;
        boolean a = query(node * 2, s, mid, l, r);
        boolean b = query(node * 2 + 1, mid + 1, e, l, r);
        if (!a || !b)
            return false;
        return true;
    }

    private Node update(int node, int s, int e, int idx) {
        if (s > idx || idx > e) return tree[node];

        if (s == e) {
            tree[node].min = arr[s];
            tree[node].max = arr[s];
            return tree[node];
        }

        int mid = (s + e) >> 1;
        Node a = update(node * 2, s, mid, idx);
        Node b = update(node * 2 + 1, mid + 1, e, idx);
        tree[node].min = Math.min(a.min, b.min);
        tree[node].max = Math.max(a.max, b.max);
        return tree[node];
    }

    private Node init(int node, int s, int e) {
        if (s == e)
            return tree[node] = new Node(s, s);

        int mid = (s + e) >> 1;
        Node a = init(node * 2, s, mid);
        Node b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
    }

    static class Node {
        int min;
        int max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
