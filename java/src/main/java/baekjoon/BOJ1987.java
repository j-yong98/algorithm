package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, 1, -1};

    int N;
    int M;
    int ans;
    char[][] arr;
    int[][] visited;


    /**
     * 알파벳
     * 비트마스킹을 통해 최근에 온 경로를 저장 하고 이후 재 방문시 해당 경로를 이전에 온 같은 알파벳 조합인지 판단하여 return
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }


        dfs(0, 0, 1, (1 << (arr[0][0] - 'A')));
        System.out.println(ans);
    }


    private void dfs(int y, int x, int cnt, int visit) {

        if (visited[y][x] == visit) return;

        ans = Math.max(ans, cnt);
        visited[y][x] = visit;

        for (int i = 0; i < 4; i++) {
            int yy = y + DY[i];
            int xx = x + DX[i];
            if (!inRange(yy, xx) || (visit & (1 << (arr[yy][xx] - 'A'))) != 0) continue;
            dfs(yy, xx, cnt + 1, visit | (1 << (arr[yy][xx] - 'A')));
        }
    }


    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
