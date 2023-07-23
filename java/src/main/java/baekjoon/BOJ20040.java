package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20040 {
    int n, m;
    int[] parent;
    /**
     * 사이클 게임
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (findParent(a) == findParent(b)) {
                System.out.println(i);
                return;
            } else
                union(a, b);
        }
        System.out.println(0);
        br.close();
    }

    private int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2)
            parent[p1] = parent[p2];
    }
}
