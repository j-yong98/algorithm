package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1989 {
    int N;
    int[] arr;
    int[] minTree;
    long[] sumTree;
    long ans = 0;
    int[] pos = new int[2];

    /**
     * 부분 배열 고르기 2
     * 분할 정복 + 세그먼트 트리 활용
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        minTree = new int[4 * N];
        sumTree = new long[4 * N];
        arr[N] = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);
        minInit(1, 0, N - 1);
        f(0, N - 1);
        System.out.println(ans + "\n" + (pos[0] + 1) + " " + (pos[1] + 1));
    }

    private void f(int s, int e) {
        if (s > e) return;
        long sum = sumQuery(1, 0, N - 1, s, e);
        int minIdx = minQuery(1, 0, N - 1, s, e);

        long res = sum * arr[minIdx];
        if (ans < res) {
            ans = res;
            pos[0] = s;
            pos[1] = e;
        }
        if (s == e) return;

        f(s, minIdx - 1);
        f(minIdx + 1, e);
    }

    private int minQuery(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return N;

        if (s >= l && r >= e) return minTree[node];

        int mid = (s + e) >> 1;
        int a = minQuery(node * 2, s, mid, l, r);
        int b = minQuery(node * 2 + 1, mid + 1, e, l, r);
        return arr[a] > arr[b] ? b : a;
    }

    private long sumQuery(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return sumTree[node];

        int mid = (s + e) >> 1;
        long a = sumQuery(node * 2, s, mid, l, r);
        long b = sumQuery(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private long init(int node, int s, int e) {
        if (s == e) return sumTree[node] = arr[s];

        int mid = (s + e) >> 1;
        long a = init(node * 2, s, mid);
        long b = init(node * 2 + 1, mid + 1, e);
        return sumTree[node] = a + b;
    }

    private int minInit(int node, int s, int e) {
        if (s == e) return minTree[node] = s;

        int mid = (s + e) >> 1;
        int a = minInit(node * 2, s, mid);
        int b = minInit(node * 2 + 1, mid + 1, e);
        return minTree[node] = arr[a] > arr[b] ? b : a;
    }
}
