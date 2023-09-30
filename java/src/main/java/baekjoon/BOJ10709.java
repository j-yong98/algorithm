package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10709 {
    int H, W;
    char[][] arr;
    /**
     * 기상 캐스터
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new char[H][W];
        for (int i = 0; i < H; i++)
            arr[i] = br.readLine().toCharArray();
        bfs();
        br.close();
    }

    private void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[H][W];
        for (int i = 0; i < H; i++)
            Arrays.fill(dist[i], -1);

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == '.') continue;
                q.add(new int[]{i, j});
                dist[i][j] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            int x = pos[1] + 1;
            if (x >= W || (dist[pos[0]][x] != -1 && dist[pos[0]][x] <= dist[pos[0]][pos[1]] + 1)) continue;
            q.add(new int[]{pos[0],x});
            dist[pos[0]][x] = dist[pos[0]][pos[1]] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++)
                sb.append(dist[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
