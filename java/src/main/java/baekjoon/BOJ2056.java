package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2056 {
    int N;
    int[] count;
    int[] time;
    Set<Integer>[] edges;

    /**
     * 작업
     * 위상정렬 풀이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new HashSet[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new HashSet<>();
        time = new int[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (i == num || num == 0) continue;
                if (!edges[num].contains(i)) {
                    edges[num].add(i);
                    count[i]++;
                }
            }
        }

        int[] res = new int[N + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            res[i] = time[i];
            if (count[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.pollFirst();

            for (Integer next : edges[now]) {
                res[next] = Math.max(res[next], res[now] + time[next]);
                if (--count[next] == 0)
                    q.add(next);
            }
        }

        System.out.println(Arrays.stream(res, 1, N + 1).max().getAsInt());
    }
}
