package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11060 {
    int N;
    int[] arr;
    /**
     * 점프 점프
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == N - 1) {
                System.out.println(now[1]);
                return;
            }
            for (int i = 1; i <= arr[now[0]]; i++) {
                if (now[0] + i >= N) break;
                if (visited[now[0] + i]) continue;
                visited[now[0] + i] = true;
                q.add(new int[]{now[0] + i, now[1] + 1});
            }
        }
        System.out.println(-1);
        br.close();
    }
}
