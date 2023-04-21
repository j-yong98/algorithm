package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ17471 {
    int n;
    int[] population;
    int[][] linked;
    int[] status;
    int ans = Integer.MAX_VALUE;

    /**
     * 게리맨더링
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        population = new int[n];
        linked = new int[n][n];
        status = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            population[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                linked[i][num] = 1;
            }
        }
        comb(0);
        if (ans == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(Integer.toString(ans));
        bw.write("\n");
        bw.flush();
        bw.close();
    }
    private void comb(int l) {
        if (l == n) {
            if (!can(0) || !can(1))
                return;
            int redTeam = 0;
            int blueTeam = 0;
            for (int i = 0; i < n; i++) {
                if (status[i] == 1)
                    redTeam += population[i];
                else
                    blueTeam += population[i];
            }
            if (blueTeam == 0 || redTeam == 0)
                return ;
            ans = Math.min(ans, Math.abs(redTeam - blueTeam));
            return;
        }
        comb(l + 1);
        status[l] = 1;
        comb(l + 1);
        status[l] = 0;
    }
    private boolean can(int color) {
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (status[i] == color) {
                q.add(i);
                visited[i] = true;
                break ;
            }
        }
        while(!q.isEmpty()) {
            Integer num = q.pollFirst();
            for (int j = 0; j < n; j++) {
                if (!visited[j] && color == status[j] && linked[num][j] == 1) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (color == status[i] && !visited[i])
                return false;
        }
        return true;
    }
}
