package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5676 {
    int N, K;
    int[] arr;
    int[] tree;

    /**
     * 음주 코딩
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] sLine = line.split(" ");
            N = Integer.parseInt(sLine[0]);
            K = Integer.parseInt(sLine[1]);
            arr = new int[N];
            tree = new int[4 * N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0)
                    arr[i] = 0;
                else if (num > 0)
                    arr[i] = 1;
                else
                    arr[i] = -1;
            }
            init(1, 0, N - 1);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                if (cmd == 'C') {
                    int idx = Integer.parseInt(st.nextToken()) - 1;
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 0)
                        arr[idx] = 0;
                    else if (val > 0)
                        arr[idx] = 1;
                    else
                        arr[idx] = -1;
                    update(1, 0, N - 1, idx);
                } else {
                    int s = Integer.parseInt(st.nextToken()) - 1;
                    int e = Integer.parseInt(st.nextToken()) - 1;
                    long res = query(1, 0, N - 1, s, e);
                    if (res == 0)
                        sb.append(0);
                    else if (res > 0)
                        sb.append("+");
                    else
                        sb.append("-");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int update(int node, int left, int right, int idx) {
        if (left > idx || right < idx) return tree[node];

        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        int a = update(node * 2, left, mid, idx);
        int b = update(node * 2 + 1, mid + 1, right, idx);
        return tree[node] = merge(a, b);
    }

    private int query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 1;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        int a = query(node * 2, left, mid, s, e);
        int b = query(node * 2 + 1, mid + 1, right, s, e);
        return merge(a, b);
    }

    private int init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = merge(a, b);
    }

    private int merge(int a, int b) {
        return a * b;
    }
}
