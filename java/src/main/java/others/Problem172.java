package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem172 {
    final int MAX = 500_000_000;
    int T;
    int N;
    int[] end = new int[2];
    int[] endDist = new int[11];
    int[][] pos = new int[11][2];
    int[][] dp = new int[11][1 << 11];

    /**
     * 최적 경로
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[0][0] = Integer.parseInt(st.nextToken());
            pos[0][1] = Integer.parseInt(st.nextToken());

            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++)
                endDist[i] = getDist(pos[i], end);

            for (int i = 0; i <= N; i++)
                Arrays.fill(dp[i], -1);

            sb.append("#").append(t).append(" ").append(getMinDist(0, 1)).append("\n");
        }
        System.out.println(sb);
    }

    private int getMinDist(int now, int visited) {
        if (visited == (1 << (N + 1)) - 1) {
            return endDist[now];
        }

        if (dp[now][visited] != -1)
            return dp[now][visited];

        dp[now][visited] = MAX;
        for (int i = 1; i <= N; i++) {
            if (i == now) continue;
            if ((visited & (1 << i)) != 0) continue;
            dp[now][visited] = Math.min(dp[now][visited], getMinDist(i, visited | (1 << i)) + getDist(pos[now], pos[i]));
        }

        return dp[now][visited];
    }

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
