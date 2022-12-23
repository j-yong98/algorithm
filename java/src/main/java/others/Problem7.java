package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7 {
    int n, m;
    int[][] arr;

    private boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m && arr[y][x] > 0;
    }

    private int getMaxRect(int y, int x, int k, int l) {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                if (!inRange(y+i,x+j)) return 0;
                cnt++;
            }
        }
        return cnt;
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= m; l++) {
                        int sum = getMaxRect(i, j, k, l);
                        if (sum > 0) {
                            ans = Math.max(ans, sum);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}
