package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ19942 {
    int N;
    int[][] arr;
    int[] min;
    int ans = Integer.MAX_VALUE;
    String orders = "";
    List<Integer> pick = new ArrayList<>();

    /**
     * 다이어트
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new int[N][4];
        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0, 0, 0, 0, 0, 0);
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(ans);
            System.out.println(orders);
        }
    }

    private void dfs(int n, int cost, int p, int f, int s, int v) {
        if (cost > ans) return;
        if (n == N) {
            if (p < min[0] || f < min[1] || s < min[2] || v < min[3]) return;
            StringBuilder sb = new StringBuilder();
            for (Integer i : pick)
                sb.append(i + 1).append(" ");
            if (ans > cost) {
                ans = cost;
                orders = sb.toString();
            } else if (ans == cost) {
                int c = orders.compareTo(sb.toString());
                if (c > 0)
                    orders = sb.toString();
            }
            return;
        }
        int[] nutrients = arr[n];
        pick.add(n);
        dfs(n + 1, cost + nutrients[4], p + nutrients[0], f + nutrients[1], s + nutrients[2],v + nutrients[3]);
        pick.remove(pick.size() - 1);
        dfs(n + 1, cost, p, f, s, v);
    }
}
