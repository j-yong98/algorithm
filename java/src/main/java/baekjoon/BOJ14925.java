package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14925 {
    final int BLANK = 0;
    final int TREE = 1;
    final int ROCK = 2;
    int N, M;
    int[][] arr;
    int[][] dp;
    /**
     * 문제이름
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            if (arr[i][0] != BLANK) continue;
            dp[i][0] = 1;
        }
        for (int i = 0; i < M; i++) {
            if (arr[0][i] != BLANK) continue;
            dp[0][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (arr[i][j] != BLANK) continue;
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        int ans = Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
        System.out.println(ans);
        br.close();
    }
}
