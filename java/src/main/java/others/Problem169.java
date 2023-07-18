package others;

import java.io.*;
import java.util.*;

public class Problem169 {
    /**
     * 작업 순서
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Integer>[] list = new List[v + 1];
            for (int i = 1; i <= v; i++)
                list[i] = new ArrayList<>();
            int[] cnt = new int[v + 1];
            for (int i = 0; i < e; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                cnt[b]++;
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= v; i++) {
                if (cnt[i] == 0) {
                    q.add(i);
                    cnt[i] = -1;
                }
            }
            System.out.print("#" + t + " ");
            while (!q.isEmpty()) {
                int now = q.pollFirst();
                System.out.print(now + " ");
                for (int i = 0; i < list[now].size(); i++) {
                    int next = list[now].get(i);
                    if (cnt[next] == -1) continue;
                    cnt[next]--;
                }
                for (int i = 1; i <= v; i++) {
                    if (cnt[i] == 0) {
                        cnt[i] = -1;
                        q.add(i);
                    }
                }
            }
            System.out.println();
        }
    }
}
