package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22234 {
    int N, T, W;
    int M;
    Deque<Person> q = new ArrayDeque<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    StringBuilder sb = new StringBuilder();

    /**
     * 가희와 은행
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            q.add(new Person(id, t));
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{id, t, c});
        }
        process();
        System.out.println(sb);
    }

    private void process() {
        int time = 0;
        while (time < W && !q.isEmpty()) {
            Person p = q.pollFirst();

            for (int i = 0; i < (int) Math.min(p.t, T); i++) {
                if (time >= W) break;
                sb.append(p.id).append("\n");
                time++;
            }
            if (time >= W) break;

            while (!pq.isEmpty() && time >= pq.peek()[2]) {
                int[] tmp = pq.poll();
                q.addLast(new Person(tmp[0], tmp[1]));
            }
            if (p.t > T)
                q.addLast(new Person(p.id, p.t - T));
        }
    }

    static class Person {
        int id;
        int t;

        public Person(int id, int t) {
            this.id = id;
            this.t = t;
        }
    }
}
