package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BOJ11437 {
    int n, m;
    List<Integer>[] tree;
    int[] parent;
    int[] level;
    /**
     * lca(lowest common ancestor)
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        level = new int[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            tree[p].add(c);
            tree[c].add(p);
        }
        init();
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            bw.write(findAncestor(a, b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void init() {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        visited[1] = true;
        level[1] = 1;
        q.add(1);
        while (!q.isEmpty()) {
            Integer node = q.pollFirst();
            for (int i = 0; i < tree[node].size(); i++) {
                int next = tree[node].get(i);
                if (visited[next]) continue;
                visited[next] = true;
                level[next] = level[node] + 1;
                parent[next] = node;
                q.add(next);
            }
        }
    }
    private int findAncestor(int a, int b) {
        if (level[a] < level[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (level[a] != level[b])
            a = parent[a];
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
