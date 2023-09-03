package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12899 {
    final int MAX = 2_000_000;
    int N;
    int[] tree = new int[4 * MAX + 1];

    /**
     * 데이터 구조
     * 최대 범위만큼 트리를 구성 후
     * 삽입이 들어 올 때마다 리프노드(값)의 카운트를 1올려준다. 부모 노드들은 자식의 카운트 개수 합
     * 구조적으로 왼쪽자식 노드들은 오른쪽 자식 노드 보다 숫자가 작은 것이 보장 된다.
     * 때문에 k번째를 찾을 때 왼쪽 노드의 카운트 개수보다 k가 크다면 k는 오른쪽 자식 노드로 이동을 해야 하며 왼쪽 자식 노드 개수 만큼 건너 뛰었기 떄문에
     * 왼쪽 자식 노드 수를 빼준다
     * 왼쪽 자식 노드보다 작거나 같다면 아직 왼쪽 노드에게 있는 것이기 떄문에 왼쪽 자식 노드로 내려간다.
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if (cmd == 1)
                update(1, 1, MAX, val);
            else
                sb.append(query(1, 1, MAX, val)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int query(int node, int left, int right, int value) {
        if (left == right) {
            tree[node] -= 1;
            return left;
        }

        int mid = (left + right) / 2;
        int res;
        if (tree[node * 2] >= value) res = query(node * 2, left, mid, value);
        else res = query(node * 2 + 1, mid + 1, right, value - tree[node * 2]);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return res;
    }

    private int update(int node, int left, int right, int value) {
        if (left == right) return tree[node] += 1;

        int mid = (left + right) / 2;
        if (mid >= value) update(node * 2, left, mid, value);
        else update(node * 2 + 1, mid + 1, right, value);
        return tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
