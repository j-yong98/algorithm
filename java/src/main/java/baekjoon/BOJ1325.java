package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1325 {
    int n, m;
    List<Integer>[] list;
    int[] cnt;

    /**
     * 효율적인 해킹
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        list = new List[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        cnt = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for (int i = 1; i <= n; i++)
            bfs(i);
        int max = Arrays.stream(cnt).max().getAsInt();
        for (int i = 1; i <= n; i++) {
            if (max == cnt[i])
                bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.pollFirst();
            for (Integer next : list[now]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
                cnt[next]++;
            }
        }
    }
}
