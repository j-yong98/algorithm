package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ26146 {
    int N, M;
    List<List<Integer>> edges = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    int ans = 0;
    int[] tmp;
    boolean[] isFinish;
    int id;
    /**
     * 즉흥 여행 (Easy)
     * SCC 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tmp = new int[N + 1];
        isFinish = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
        }
        for (int i = 1; i <= N; i++) {
            if (isFinish[i]) continue;
            if (ans > 1) break;
            dfs(i);
        }
        if (ans == 1)
            System.out.println("Yes");
        else
            System.out.println("No");
        br.close();
    }

    private int dfs(int start) {
        if (ans > 1) return 0;
        tmp[start] = ++id;
        s.push(start);

        int parent = tmp[start];
        for (int next : edges.get(start)) {
            if (tmp[next] == 0) parent = Math.min(parent, dfs(next));
            else if (!isFinish[next]) parent = Math.min(parent, tmp[next]);
        }

        if (parent == tmp[start]) {
            while (true) {
                int top = s.pop();
                isFinish[top] = true;
                if (start == top)
                    break;
            }
            ans++;
        }
        return parent;
    }
}
