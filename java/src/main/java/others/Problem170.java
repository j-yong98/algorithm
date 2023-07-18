package others;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem170 {
    final int MAX = 10_000_000;
    int[][] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] dist = new int[n];
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                dist[i] = getPath(i, n);
            }
            bw.write("#" + t + " " + Arrays.stream(dist).min().getAsInt() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int getPath(int s, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        dist[s] = 0;
        Deque<Integer> q = new ArrayDeque<>();

        q.add(s);
        while (!q.isEmpty()) {
            int now = q.pollFirst();
            for (int i = 0; i < n; i++) {
                if (arr[now][i] == 1 && dist[i] > dist[now] + 1) {
                    dist[i] = dist[now] + 1;
                    q.add(i);
                }
            }
        }
        return Arrays.stream(dist).sum();
    }
}
