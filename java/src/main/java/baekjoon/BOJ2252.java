package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {
    int N, M;
    int[] count;
    List<List<Integer>> edges = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    /**
     * 줄 세우기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N + 1];
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            count[b]++;
            edges.get(a).add(b);
        }
        topological();
        System.out.println(sb);
    }

    private void topological() {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            Integer now = q.pollFirst();

            sb.append(now).append(" ");
            for (Integer next : edges.get(now)) {
                if (--count[next] == 0)
                    q.add(next);
            }
        }
    }
}
