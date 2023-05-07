package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2098 {
    final int MAX = 16_000_000;

    int N;
    int[][] arr;
    int[][] dist;

    /**
     * 외판원 순회
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dist = new int[N][(1 << N)];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], -1);
        System.out.println(TSP(0, 1));
    }

    private int TSP(int now, int visited) {
        if (visited == (1 << N) - 1) {
            if (arr[now][0] == 0)
                return MAX;
            return arr[now][0];
        }
        if (dist[now][visited] != -1)
            return dist[now][visited];
        dist[now][visited] = MAX;
        for (int i = 0; i < N; i++) {
            if (arr[now][i] == 0)
                continue;
            if ((visited & (1 << i)) != 0)
                continue;
            dist[now][visited] = Math.min(dist[now][visited], TSP(i, visited | (1 << i)) + arr[now][i]);
        }
        return dist[now][visited];
    }
}
