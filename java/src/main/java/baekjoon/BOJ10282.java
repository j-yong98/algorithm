package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10282 {
    int T;
    int N, D, C;

    /**
     * 해킹
     * 다익스트라 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            List<List<int[]>> edges = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            int[] dist = new int[N + 1];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edges.get(b).add(new int[]{a, s});
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            Arrays.fill(dist, Integer.MAX_VALUE);
            int cnt = 0;
            int ans = 0;
            pq.add(new int[]{C, 0});
            dist[C] = 0;
            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                if (dist[now[0]] > now[1]) continue;

                for (int[] next : edges.get(now[0])) {
                    if (next[1] + dist[now[0]] >= dist[next[0]]) continue;
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
            for (int i = 1; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) continue;
                cnt += 1;
                ans = Math.max(ans, dist[i]);
            }
            System.out.println(cnt + " " + ans);
        }
    }
}
