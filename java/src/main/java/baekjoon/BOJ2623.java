package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2623 {
    int N, M;
    int[] count;
    List<List<Integer>> orders;
    List<Integer> ans = new ArrayList<>();
    /**
     * 음악 프로그램
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N + 1];
        orders = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            orders.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int pre = 0;
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (pre == 0)
                    pre = num;
                else {
                    count[num] += 1;
                    orders.get(pre).add(num);
                    pre = num;
                }
            }
        }
        getTotalOrders();
        if (ans.size() == N)
            ans.forEach(System.out::println);
        else
            System.out.println(0);
        br.close();
    }

    private void getTotalOrders() {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer now = q.pollLast();

            ans.add(now);
            for (Integer next : orders.get(now)) {
                if (--count[next] == 0)
                    q.add(next);
            }
        }
    }
}
