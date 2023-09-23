package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1707 {
    int T;
    int N, M;
    List<List<Integer>> edges;
    int[] colors;
    boolean flag;
    /**
     * 이분 그래프
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            colors = new int[N + 1];
            flag = true;
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                edges.get(u).add(v);
                edges.get(v).add(u);
            }
            for (int i = 1; i <= N; i++) {
                if (!flag) break;
                if (colors[i] == 0)
                    dfs(i, 1);
            }
            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
        br.close();
    }

    private void dfs(int start, int color) {
        colors[start] = color;

        for (int next : edges.get(start)) {
            if (colors[next] == color) {
                flag = false;
                return;
            }
            if (colors[next] == 0)
                dfs(next, -color);
        }
    }
}
