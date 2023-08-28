package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ12851 {
    final int MAX = 100_000;
    int N, K;


    /**
     * 숨바꼭질 2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) System.out.println("0\n1");
        else bfs();
    }

    private void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[MAX + 1];
        int[] count = new int[MAX + 1];
        Arrays.fill(dist, 100_000_000);

        q.add(N);
        dist[N] = 0;
        while (!q.isEmpty()) {
            Integer now = q.pollFirst();

            int sub = now - 1;
            int add = now + 1;
            int mul = now * 2;

            if (mul <= MAX && dist[now] + 1 <= dist[mul]) {
                if(dist[mul] == 100_000_000) {
                    dist[mul] = dist[now] + 1;
                    count[mul] = 1;
                }
                else if (dist[mul] == dist[now] + 1)
                    count[mul] += 1;
                q.add(mul);
            }
            if (add <= MAX && dist[now] + 1 <= dist[add]) {
                if(dist[add] == 100_000_000) {
                    dist[add] = dist[now] + 1;
                    count[add] = 1;
                }
                else if (dist[add] == dist[now] + 1)
                    count[add] += 1;
                q.add(add);
            }
            if (sub >= 0 && dist[now] + 1 <= dist[sub]) {
                if(dist[sub] == 100_000_000) {
                    dist[sub] = dist[now] + 1;
                    count[sub] = 1;
                }
                else if (dist[sub] == dist[now] + 1)
                    count[sub] += 1;
                q.add(sub);
            }
        }
        System.out.println(dist[K]);
        System.out.println(count[K]);
    }
}
