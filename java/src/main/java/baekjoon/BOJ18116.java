package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18116 {
    final int MAX = 10_000_000;
    int N;
    int[] parent;
    int[] count;

    /**
     * 로봇 조립
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        parent = new int[MAX + 1];
        count = new int[MAX + 1];
        Arrays.fill(count, 1);
        for (int i = 1; i <= MAX; i++)
            parent[i] = i;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int p = findParent(Integer.parseInt(st.nextToken()));
                sb.append(count[p]).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 == p2) return;
        if (p1 < p2) {
            parent[p2] = p1;
            count[p1] += count[p2];
            count[p2] = 0;
        }
        else {
            parent[p1] = p2;
            count[p2] += count[p1];
            count[p1] = 0;
        }
    }

    private int findParent(int a) {
        if (a == parent[a]) return a;
        return parent[a] = findParent(parent[a]);
    }
}
