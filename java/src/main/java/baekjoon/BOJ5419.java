package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ5419 {
     int T;
     int N;
     List<Node> pos;
     int[] tree;
    /**
     * 북서풍
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            pos = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pos.add(new Node(x, y));
            }

            Collections.sort(pos, (a, b) -> b.y - a.y);
            int[] tmp = new int[N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (i > 0 && pos.get(i - 1).y != pos.get(i).y) cnt++;
                tmp[i] = cnt;
            }

            for (int i = 0; i < N; i++)
                pos.get(i).y = tmp[i];

            Collections.sort(pos, (a, b) -> a.x == b.x ? a.y - b.y : a.x - b.x);
            tree = new int[4 * N];
            long ans = 0;
            for (int i = 0; i < N; i++) {
                ans += query(1, 0, cnt, 0, pos.get(i).y);
                update(1, 0, cnt, pos.get(i).y);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private void update(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;

        tree[node] += 1;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
    }

     static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
