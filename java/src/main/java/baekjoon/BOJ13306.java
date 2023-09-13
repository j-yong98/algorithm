package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ13306 {
    int N, Q;
    int[] unionTable;
    int[] parent;
    Deque<int[]> q = new ArrayDeque<>();

    /**
     * 트리
     * 오프라인 쿼리 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        unionTable = new int[N + 1];
        Arrays.fill(unionTable, -1);
        for (int i = 1; i < N; i++) {
            parent[i + 1] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < Q + N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int[] cmd = new int[3];
            cmd[0] = Integer.parseInt(st.nextToken());
            cmd[1] = Integer.parseInt(st.nextToken());
            if (cmd[0] == 1)
                cmd[2] = Integer.parseInt(st.nextToken());
            q.push(cmd);
        }
        Deque<String> ans = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] query = q.pop();
            if (query[0] == 0) {
                union(parent[query[1]], query[1]);
            } else {
                if (findParent(query[1]) == findParent(query[2]))
                    ans.offerLast("YES\n");
                else
                    ans.offerLast("NO\n");
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!ans.isEmpty())
            sb.append(ans.pollLast());
        System.out.print(sb);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2)
            unionTable[p2] = p1;
    }

    private int findParent(int a) {
        if (unionTable[a] == -1) return a;
        return unionTable[a] = findParent(unionTable[a]);
    }
}
