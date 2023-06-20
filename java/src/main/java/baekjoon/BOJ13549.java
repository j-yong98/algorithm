package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ13549 {
    final int MAX = 100_000;
    int n, k;
    boolean[] visited = new boolean[MAX + 1];
    int min = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n, 0});
        visited[n] = true;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            visited[pos[0]] = true;
            if (pos[0] == k)
                min = Math.min(min, pos[1]);
            if (pos[0] * 2 <= MAX && !visited[pos[0] * 2])
                q.add(new int[]{pos[0] * 2, pos[1]});
            if (pos[0] + 1 <= MAX && !visited[pos[0] + 1])
                q.add(new int[]{pos[0] + 1, pos[1] + 1});
            if (pos[0] - 1 >= 0 && !visited[pos[0] - 1])
                q.add(new int[]{pos[0] - 1, pos[1] + 1});
        }
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
