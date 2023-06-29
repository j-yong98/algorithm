package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1967 {
    int n;
    List<Integer>[] tree;
    int[] costs;
    int ans = 0;

    /**
     * 트리의 지름
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new List[n + 1];
        costs = new int[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            tree[p].add(c);
            costs[c] = cost;
        }
        int res = getMaxDiameter(1);
        ans = Math.max(ans, res);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int getMaxDiameter(int node) {
        if (tree[node].isEmpty()) return costs[node];
        if (tree[node].size() == 1) return costs[node] + getMaxDiameter(tree[node].get(0));

        int size = tree[node].size();
        int[] weight = new int[size];
        for (int i = 0; i < tree[node].size(); i++)
            weight[i] = getMaxDiameter(tree[node].get(i));

        Arrays.sort(weight);
        ans = Math.max(ans, weight[size - 1] + weight[size - 2]);
        return costs[node] + weight[size - 1];
    }
}
