package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ9019 {
    final int MAX = 10_000_000;
    final int MOD = 10000;
    int T;
    int a, b;
    StringBuilder sb = new StringBuilder();

    /**
     * DSLR
     * DSLR연산으로 a -> b로 하는 최소 연산 횟수
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);

            boolean[] visited = new boolean[MOD];
            Arrays.fill(visited, false);
            String[] ans = new String[MOD];
            Arrays.fill(ans, "");
            Deque<Integer> q = new ArrayDeque<>();
            visited[a] = true;
            q.add(a);

            while (!q.isEmpty()) {
                int now = q.pollFirst();

                int d = (now * 2) % MOD;
                int s = (now + MOD - 1) % MOD;
                int l = (now % 1000) * 10 + (now / 1000);
                int r = (now % 10) * 1000 + (now / 10);

                if (!visited[d]) {
                    visited[d] = true;
                    q.offerLast(d);
                    ans[d] = ans[now] + "D";
                }

                if (!visited[s]) {
                    visited[s] = true;
                    q.offerLast(s);
                    ans[s] = ans[now] + "S";
                }

                if (!visited[l]) {
                    visited[l] = true;
                    q.offerLast(l);
                    ans[l] = ans[now] + "L";
                }

                if (!visited[r]) {
                    visited[r] = true;
                    q.offerLast(r);
                    ans[r] = ans[now] + "R";
                }
            }

            sb.append(ans[b]).append("\n");
        }
        System.out.print(sb);
    }
}
