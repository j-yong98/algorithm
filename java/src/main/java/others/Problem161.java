package others;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem161 {
    int T;
    int v, e;
    int c1, c2;
    int[] parent;
    int[] level;
    List<Integer>[] tree;
    /**
     * 공통 조상
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            parent = new int[v + 1];
            level = new int[v + 1];
            tree = new List[v + 1];
            for (int i = 1; i <= v; i++)
                tree[i] = new ArrayList();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int p = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                parent[child] = p;
                tree[p].add(child);
            }
            for (int i = 2; i <= v; i++)
                setLevel(0, i);
            if (level[c1] < level[c2]) {
                int tmp = c1;
                c1 = c2;
                c2 = tmp;
            }
            while (level[c1] != level[c2])
                c1 = parent[c1];
            while (parent[c1] != parent[c2]) {
                c1 = parent[c1];
                c2 = parent[c2];
            }
            bw.write("#" + t + " " + parent[c1] + " " + getSize(parent[c1]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int getSize(int node) {
        if (tree[node].isEmpty())
            return 1;
        int len = tree[node].size();
        int size = 0;
        for (int i = 0; i < len; i++)
            size += getSize(tree[node].get(i));
        return size + 1;
    }

    private int setLevel(int l, int node) {
        if (node == 0)
            return 1;
        level[node] = setLevel(l + 1, parent[node]);
        return level[node] + 1;
    }
}
