package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1849 {
    int N;
    int[] arr;
    int[] tree;
    int[] ans;

    /**
     * 순열
     * 세그먼트 트리 풀이
     * 작은 수부터 자리를 선정함.
     * 세그트리의 개수 -> 내 뒤에 올 수 있는 큰 수의 개수를 의미함
     * 왼쪽으로 간다면 내가 볼 수 있는 큰 수의 개수가 됨
     * 오른쪽으로 간다면 왼쪽의 개수만큼 내가 볼 수 있는 개수가 차감 된다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        ans = new int[N + 1];
        tree = new int[4 * N];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        init(1, 1, N);
        for (int i = 1; i <= N; i++) {
            int idx = query(1, 1, N, arr[i]);
            ans[idx] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(ans[i]).append("\n");
        System.out.print(sb);
    }

    private int query(int node, int left, int right, int val) {
        if (left == right) {
            tree[node] -= 1;
            return left;
        }

        int res;
        int mid = (left + right) >> 1;
        if (tree[node * 2] > val)
            res = query(node * 2, left, mid, val);
        else
            res = query(node * 2 + 1, mid + 1, right, val - tree[node * 2]);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return res;
    }
    private int init(int node, int left, int right) {
        if (left == right) return tree[node] = 1;

        int mid = (left + right) >> 1;
        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = a + b;
    }
}
