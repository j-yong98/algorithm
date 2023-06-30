package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1068 {
    int n;
    List<Integer>[] tree;
    int root;
    int remove;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(line[i]);
            if (parent != -1)
                tree[parent].add(i);
            else
                root = i;
        }
        remove = Integer.parseInt(br.readLine());
        int res = leafNode(root);
        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
        return res;
    }

    private int leafNode(int node) {
        if (node == remove)
            return 0;
        if (tree[node].size() == 0)
            return 1;
        int ret = 0;
        for (Integer child : tree[node])
            ret += leafNode(child);
        if (ret == 0)
            return 1;
        return ret;
    }
}
