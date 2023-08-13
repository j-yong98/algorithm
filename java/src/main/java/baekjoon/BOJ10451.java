package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10451 {
    int T;
    int N;
    int[] arr;
    int[] table;
    Set<Integer> set = new HashSet<>();
    /**
     * 순열 싸이클
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            table = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++)
                table[i] = i;
            for (int i = 1; i <= N; i++) {
                if (table[i] != i) continue;
                findCycle(i);
            }
            set.clear();
            for (int i = 1; i <= N; i++)
                set.add(table[i]);
            System.out.println(set.size());
        }
        br.close();
    }

    private void findCycle(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.add(start);

        while (!q.isEmpty()) {
            Integer now = q.pollFirst();

            if (!visited[now])
                visited[now] = true;

            if (findParent(now) != findParent(arr[now])) {
                q.add(arr[now]);
                union(now, arr[now]);
            }
        }
    }

    private int findParent(int a) {
        if (a == table[a]) return a;
        return findParent(table[a]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            if (p1 < p2)
                table[p2] = p1;
            else
                table[p1] = p2;
        }
    }
}
