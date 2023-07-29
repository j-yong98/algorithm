package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    final int MAX = 256;
    int n, m, b;
    int[][] arr;

    /**
     * 마인크래프트
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        int height = 0;
        for (int h = 0; h <= MAX; h++) {
            int time = 0;
            int block = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] > h) {
                        time += (arr[i][j] - h) * 2;
                        block += (arr[i][j] - h);
                    } else if (arr[i][j] < h) {
                        time += h - arr[i][j];
                        block -= h - arr[i][j];
                    }
                }
            }

            if (block < 0) break;
            if (time < ans) {
                ans = time;
                height = h;
            } else if (time == ans)
                height = h;
        }
        System.out.println(ans + " " +  height);
        br.close();
    }
}
