package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17503 {
    int n, m, k;
    Beer[] beers;

    /**
     * 맥주 축제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        beers = new Beer[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers[i] = new Beer(v, c);
        }
        Arrays.sort(beers, new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if (o2.c == o1.c)
                    return o2.v - o1.v;
                return o1.c - o2.c;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            pq.add(beers[i].v);
            sum += beers[i].v;
            if (pq.size() > n)
                sum -= pq.poll();
            if (pq.size() == n && m <= sum) {
                System.out.println(beers[i].c);
                return;
            }
        }
        System.out.println(-1);
    }

    class Beer {
        int v;
        int c;

        public Beer(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
