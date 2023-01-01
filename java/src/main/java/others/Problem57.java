package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem57 {
    int n;
    int[][] arr;
    int[][] dir;
    int[][] visited;
    int r, c;

    int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    int ans = 0;

    private boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private void f(int row, int col, int cnt) {
        int y = row;
        int x = col;
        while (true){
            int yy = y + dy[dir[row][col]];
            int xx = x + dx[dir[row][col]];
            if (!inRange(yy,xx)) break;
            if (visited[yy][xx] == 0 && arr[row][col] < arr[yy][xx]){
                visited[yy][xx] = 1;
                f(yy,xx,cnt+1);
                visited[yy][xx] = 0;
            }
            y = yy;
            x = xx;
        }
        ans = Math.max(ans,cnt);
    }

    /**
     * 방향에 맞춰 최대로 움직이기
     * NxN크기의 격자에 방향과 숫자가 적혀있다. 해당 칸의 방향으로 이동 했을 때 이동한 칸의 수가 이전 칸의 숫자보다 커야한다.
     * 이 때 최대로 움직일 수 있는 칸 수
     * @throws IOException
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dir = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dir[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        visited[r][c] = 1;
        f(r,c,0);
        System.out.println(ans);
    }
}
