package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem109 {
    int T;
    int n, m;
    int[][] arr;
    /**
     * 파리 퇴치
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int r = 0; r < m; r++) {
                        if (r + i >= n) break ;
                        for (int c = 0; c < m; c++) {
                            if (c + j >= n) break ;
                            sum += arr[i + r][j + c];
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
