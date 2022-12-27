package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem37 {
    int n;
    int[][] arr;

    int ans;

    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};

    /**
     * 1 - /, 상(0) - 우(3), 하(1) - 좌(2), 좌(2) - 하(1), 우(3) - 상(0)
     * 2 - \, 상(0) - 좌(2), 하(1) - 우(3), 좌(2) - 상(0), 우(3) - 하(1)
     */
    private int getDir(int now, int dir) {
        if (now == 1){
            return 3 - dir;
        }
        else{
            return dir < 2 ? dir + 2 : dir - 2;
        }
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    private int move(int y, int x, int d) {
        int cnt = 1;
        while (true) {
            cnt++;
            if (arr[y][x] != 0) {
                d = getDir(arr[y][x],d);
            }
            int cy = y + dy[d];
            int cx = x + dx[d];
            if (!inRange(cy, cx)) break;
            y = cy;
            x = cx;
        }
        return cnt;
    }

    /**
     * 시작점 = 0,i, i,0, i,n-1, n-1,i
     */
    private void simulate() {
        for (int i = 0; i < n; i++) {
            int cnt = move(n - 1, i, 0);
            ans = Math.max(ans, cnt);

            cnt = move(0, i, 1);
            ans = Math.max(ans, cnt);

            cnt = move(i, n - 1, 2);
            ans = Math.max(ans, cnt);

            cnt = move(i, 0, 3);
            ans = Math.max(ans, cnt);
        }
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        simulate();
        System.out.println(ans);
        return ans;
    }
}
