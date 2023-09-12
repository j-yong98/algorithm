package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1777 {
    int N;
    int[] arr;
    int[] tree;
    int[] ans;

    /**
     * 순열복원
     * 세그먼트 트리 문제
     * K번째 수 찾기와 비슷한 풀이
     * 세그트리를 처음에 현재 숫자의 개수로 초기화
     * 이후 오른쪽 자식 노드와 비교를 하는데
     * 만약 오른쪽 자식이 더 작다면 현재 내가 볼 수 있는 개수를 충족 할 수 없으므로
     * 왼쪽으로 이동, 이동할 때 오른쪽 노드의 개수를 볼 수 있기 때문에 오른쪽 노드의 개수를 빼준다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[4 * N];
        arr = new int[N + 1];
        ans = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
        }
        init(1, 1, N);
        for (int i = N; i >= 1; i--) {
            int idx = query(1, 1, N, arr[i]);
            ans[idx] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(ans[i]).append(" ");
        System.out.println(sb);
        br.close();
    }

    private int query(int node, int left, int right, int val) {
        if (left == right) {
            tree[node] -= 1;
            return left;
        }

        int res;
        int mid = (left + right) >> 1;
        if (tree[node * 2 + 1] > val)
            res = query(node * 2 + 1, mid + 1, right, val);
        else
            res = query(node * 2, left, mid, val - tree[node * 2 + 1]);
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
