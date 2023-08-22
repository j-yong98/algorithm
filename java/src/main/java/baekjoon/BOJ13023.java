package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {
    final int LIMIT = 5;
    int N, M;
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;
    boolean success = false;

    /**
     * ABCDE
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++)
            list.add(new ArrayList<>());
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;
            if (success) break;
        }
        System.out.println(success ? 1 : 0);
    }

    private void dfs(int depth, int now) {
        if (success) return;
        if (depth == LIMIT) {
            success = true;
            return;
        }
        for (int next : list.get(now)) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(depth + 1, next);
            visited[next] = false;
        }
    }
}
