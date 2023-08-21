package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1005 {
    int T;
    int N, K;
    int[] count;
    int[] delay;
    List<Integer>[] edges;
    int W;
    /**
     * ACM Craft
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = new int[N + 1];
            delay = new int[N + 1];
            edges = new List[N + 1];
            for (int i = 1; i <= N; i++)
                edges[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                delay[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges[a].add(b);
                count[b]++;
            }
            W = Integer.parseInt(br.readLine());
            topologicalSort();
        }
        br.close();
    }

    private void topologicalSort() {
        Deque<Integer> q = new ArrayDeque<>();
        int[] time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer now = q.pollFirst();
            time[now] += delay[now];
            if (now == W) break;

            for (int next : edges[now]) {
                time[next] = Math.max(time[next], time[now]);
                if (--count[next] == 0)
                    q.add(next);
            }
        }
        System.out.println(time[W]);
    }
}
