package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11403 {

    int n;
    int[][] arr;
    int[][] ans;

    /**
     * 경로 찾기
     */
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++)
            bfs(i);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    private void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.add(start);

        while (!q.isEmpty()) {
            Integer now = q.pollFirst();
            for (int i = 0; i < n; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    ans[start][i] = 1;
                }
            }
        }
    }
}
