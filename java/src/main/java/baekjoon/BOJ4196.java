package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4196 {
    int T;
    int N, M;
    int[] d;
    boolean[] isFinish;
    int id;
    List<Integer>[] edges;
    List<List<Integer>> SCC;
    Deque<Integer> s;
    int[] newCnt;
    int size;

    /**
     * 도미노
     * 강한 연결 요소 풀이 (SCC)
     * SCC를 이용하여 노드를 그룹화하여 나눈 뒤
     * 해당 그룹으로 위상정렬
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            SCC = new ArrayList<>();
            s = new ArrayDeque<>();
            edges = new List[N + 1];
            d = new int[N + 1];
            isFinish = new boolean[N + 1];
            for (int i = 0; i <= N; i++)
                edges[i] = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                edges[x].add(y);
            }
            for (int i = 1; i <= N; i++) {
                if (isFinish[i]) continue;
                dfs(i);
            }
            findEdges();
            int ans = 0;
            for (int i = 0; i < size; i++) {
                if (newCnt[i] == 0)
                    ans += 1;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private void findEdges() {
        size = SCC.size();
        newCnt = new int[size];
        for (int i = 0; i < size; i++) {
            for (int elem : SCC.get(i)) {
                d[elem] = i;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            for (int next : edges[i]) {
                if (d[next] == d[i]) continue;
                newCnt[d[next]] += 1;
            }
        }
    }

    private int dfs(int now) {
        d[now] = ++id;
        s.push(now);

        int parent = d[now];
        for (int next : edges[now]) {
            if (d[next] == 0) parent = Math.min(parent, dfs(next));
            else if (!isFinish[next]) parent = Math.min(parent, d[next]);
        }

        if (parent == d[now]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int top = s.pop();
                isFinish[top] = true;
                scc.add(top);
                if (top == now) break;
            }
            SCC.add(scc);
        }
        return parent;
    }
}
