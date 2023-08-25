package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17829 {
    int N;
    int[][] arr;
    int ans;

    /**
     * 222-풀링
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        recursion(arr, N);
        System.out.println(ans);
        br.close();
    }

    private void recursion(int[][] board, int size) {
        if (size == 1) {
            ans = board[0][0];
            return;
        }
        int next = size >> 1;
        int y = 0, x = 0;
        int[][] tmp = new int[next][next];
        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < size; j += 2) {
                List<Integer> s = new ArrayList<>();
                for (int r = 0; r < 2; r++) {
                    for (int c = 0; c < 2; c++)
                        s.add(board[i + r][j + c]);
                }
                Collections.sort(s);
                tmp[y][x] = s.get(s.size() - 2);
                if (x + 1 == next) {
                    y += 1;
                    x = 0;
                } else x++;
            }
        }
        recursion(tmp, next);
    }
}
