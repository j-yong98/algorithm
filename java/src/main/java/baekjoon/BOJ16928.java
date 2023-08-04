package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16928 {
    final int MAX = 100;
    int N, M;
    Map<Integer, Integer> move = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            move.put(u, v);
        }
        System.out.println(bfs());
    }

    private int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX + 1];

        visited[1] = true;
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            if (now[0] == MAX) return now[1];
            for (int i = 1; i <= 6; i++) {
                if (now[0] + i > MAX) break;
                if (move.containsKey(now[0] + i)) {
                    if (visited[move.get(now[0] + i)]) continue;
                    q.add(new int[]{move.get(now[0] + i), now[1] + 1});
                    visited[move.get(now[0] + i)] = true;
                } else {
                    if (visited[now[0] + i]) continue;
                    q.add(new int[]{now[0] + i, now[1] + 1});
                    visited[now[0] + i] = true;
                }
            }
        }

        return -1;
    }
}
