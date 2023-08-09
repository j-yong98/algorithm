package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2563 {
    final int ATTACH = 1;
    final int MAX = 100;
    final int SIZE = 10;
    int N;
    int[][] arr = new int[MAX + 1][MAX + 1];

    /**
     * 색종이
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int r = pos[0]; r < pos[0] + SIZE; r++) {
                for (int c = pos[1]; c < pos[1] + SIZE; c++)
                    arr[r][c] = ATTACH;
            }
        }
        int cnt = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (arr[i][j] == ATTACH)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
