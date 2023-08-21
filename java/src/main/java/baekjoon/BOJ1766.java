package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1766 {
    int N, M;
    int[] count;
    List<List<Integer>> edges = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    /**
     * 문제집
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

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Integer now = pq.poll();

            sb.append(now).append(" ");
            for (Integer next  : edges.get(now)) {
                if (--count[next] == 0)
                    pq.add(next);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
