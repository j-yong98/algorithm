package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15681 {
    int N, R, Q;
    List<List<Integer>> tree = new ArrayList<>();
    int[] dp;
    boolean[] visited;
    /**
     * 트리와 쿼리
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            tree.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        Arrays.fill(dp, 1);
        visited[R] = true;
        makeTree(R);
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(dp[q]);
        }
        br.close();
    }

    private int makeTree(int root) {
        for (int child : tree.get(root)) {
            if (visited[child]) continue;
            visited[child] = true;
            dp[root] += makeTree(child);
        }
        return dp[root];
    }
}
