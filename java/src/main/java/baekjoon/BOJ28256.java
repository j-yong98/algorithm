package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ28256 {
    final int N = 3;
    int T;
    char[][] arr;
    boolean[][] visited;
    int[] cnt;

    /**
     * 초콜릿 보관함 
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            arr = new char[N][N];
            visited = new boolean[N][N];
            cnt = new int[9];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++)
                    arr[i][j] = line.charAt(j);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int i = 0; i < a; i++)
                cnt[Integer.parseInt(st.nextToken())]++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == '-' || arr[i][j] == 'X') continue;
                    if (!visited[i][j])
                        cnt[bfs(i, j)]--;
                }
            }
            boolean flag = true;
            for (int i = 1; i <= 8; i++) {
                if (cnt[i] != 0)
                    flag = false;
            }
            bw.write(flag ? 1 + "\n" : 0 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int y, int x) {
        int cnt = 1;
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] == 'O') {
                    visited[yy][xx] = true;
                    cnt++;
                    q.add(new int[]{yy, xx});
                }
            }
        }
        return cnt;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
