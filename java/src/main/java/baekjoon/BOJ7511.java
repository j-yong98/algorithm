package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7511 {
    /**
     * 소셜 네트워킹 어플리케이션
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] group = new int[n];
            for (int i = 0; i < n; i++)
                group[i] = i;
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b, group);
            }
            int k = Integer.parseInt(br.readLine());
            sb.append("Scenario ").append(t).append(":\n");
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (findParent(u, group) == findParent(v, group))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findParent(int a, int[] parent) {
        if (parent[a] == a) return a;
        return findParent(parent[a], parent);
    }

    private static void union(int a, int b, int[] parent) {
        int p1 = findParent(a, parent);
        int p2 = findParent(b, parent);
        parent[p1] = p2;
    }
}
