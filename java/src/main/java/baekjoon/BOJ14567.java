package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14567 {
    static int n, m;
    /**
     * 선수 과목
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            cnt[b]++;
        }
        int[] ans = new int[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                cnt[i] = -1;
                q.add(i);
                ans[i] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Integer now = q.pollFirst();
            for (int i = 0; i < list[now].size(); i++) {
                cnt[list[now].get(i)]--;
            }
            for (int i = 1; i <= n; i++) {
                if (cnt[i] == 0) {
                    q.add(i);
                    cnt[i] = -1;
                    ans[i] = ans[now] + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++)
            sb.append(ans[i]).append(" ");
        System.out.println(sb);
    }
}
