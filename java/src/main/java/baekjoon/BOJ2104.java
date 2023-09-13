package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2104 {
    int N;
    long[] arr;
    int[] minTree;
    long[] sumTree;
    long ans;

    /**
     * 부분배열 고르기
     * 세그먼트, 분할정복 풀이
     * 합 세그트리와 최소 세그트리를 생성 후
     * 구간 별 최소 값의 인덱스를 구해 해당 인덱스를 제외한 부분의 분할 정복으로 최대 값 구하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        minTree = new int[4 * N];
        sumTree = new long[4 * N];
        arr[0] = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        initMin(1, 1, N);
        initSum(1, 1, N);
        ans = findAns(1, N);
        System.out.println(ans);
    }

    private long findAns(int s, int e) {
        if (s > e) return 0;
        int idx = minQuery(1, 1, N, s, e);
        long sum = sumQuery(1, 1, N, s, e);

        if (s == e) return arr[idx] * sum;

        long a = findAns(s, idx - 1);
        long b = findAns(idx + 1, e);

        return Math.max(arr[idx] * sum, Math.max(a, b));
    }

    private long sumQuery(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return sumTree[node];

        int mid = (left + right) >> 1;
        long a = sumQuery(node * 2, left, mid, s, e);
        long b = sumQuery(node * 2 + 1, mid + 1, right, s, e);
        return a + b;
    }

    private int minQuery(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return minTree[node];

        int mid = (left + right) >> 1;
        int a = minQuery(node * 2, left, mid, s, e);
        int b = minQuery(node * 2 + 1, mid + 1, right, s, e);
        if (arr[a] <= arr[b]) return a;
        return b;
    }

    private long initSum(int node, int left, int right) {
        if (left == right) return sumTree[node] = arr[left];

        int mid = (left + right) >> 1;
        long a = initSum(node * 2, left, mid);
        long b = initSum(node * 2 + 1, mid + 1, right);
        return sumTree[node] = a + b;
    }
    private int initMin(int node, int left, int right) {
        if (left == right) return minTree[node] = left;

        int mid = (left + right) >> 1;
        int a = initMin(node * 2, left, mid);
        int b = initMin(node * 2 + 1, mid + 1, right);
        if (arr[a] <= arr[b]) return minTree[node] = a;
        return minTree[node] = b;
    }
}
