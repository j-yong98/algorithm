package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13544 {
    int N, M;
    int[] arr;
    int[][] tree;
    int last_ans = 0;
    /**
     * 수열과 쿼리 3
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N][];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);
        sort(1, 0, N - 1);
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = (Integer.parseInt(st.nextToken()) ^ last_ans) - 1;
            int b = (Integer.parseInt(st.nextToken()) ^ last_ans) - 1;
            int c = Integer.parseInt(st.nextToken()) ^ last_ans;
            last_ans = query(1, 0, N - 1, a, b, c);
            sb.append(last_ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int query(int node, int s, int e, int l, int r, int k) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) {
            int idx = upper_bound(tree[node], k);
            return (e - s + 1) - idx;
        }

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r, k);
        int b = query(node * 2 + 1, mid + 1, e, l, r, k);
        return a + b;
    }

    private int upper_bound(int[] arr, int k) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (arr[mid] > k)
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }

    private void sort(int node, int s, int e) {
        if (s == e) return;

        int mid = (s + e) >> 1;
        sort(node * 2, s, mid);
        sort(node * 2 + 1, mid + 1, e);
        mergeSort(tree[node], 0, e - s);
    }

    private void init(int node, int s, int e) {
        tree[node] = new int[e - s + 1];

        for (int i = s; i <= e; i++)
            tree[node][i - s] = arr[i];
        if (s == e) return;

        int mid = (s + e) >> 1;
        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);
    }

    private void mergeSort(int[] tmp, int l, int r) {
        if (l == r) return;

        int mid = (l + r) >> 1;
        mergeSort(tmp, l, mid);
        mergeSort(tmp, mid + 1, r);
        merge(l, mid, r, tmp);
    }

    private void merge(int s, int mid, int e, int[] elem) {
        int[] tmp = new int[e - s + 1];

        int idx = 0;
        int l = s;
        int r = mid + 1;
        while (l <= mid && r <= e) {
            if (elem[l] < elem[r])
                tmp[idx++] = elem[l++];
            else
                tmp[idx++] = elem[r++];
        }

        while (l <= mid)
            tmp[idx++] = elem[l++];
        while (r <= e)
            tmp[idx++] = elem[r++];

        for (int i = s; i <= e; i++)
            elem[i] = tmp[i - s];
    }
}
