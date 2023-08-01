package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2630 {
    
    /**
     * 색종이 만들기
     */
    int n;
    int[][] arr;
    int white = 0;
    int blue = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        divPaper(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private void divPaper(int y, int x, int size) {
        if (allEqual(y, x, size) || size == 1) {
            if (arr[y][x] == 0)
                white++;
            else
                blue++;
            return;
        }

        int half = size >> 1;
        divPaper(y, x, half);
        divPaper(y, x + half, half);
        divPaper(y + half, x, half);
        divPaper(y + half, x + half, half);
    }

    private boolean allEqual(int y, int x, int size) {
        int tmp = arr[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (tmp != arr[i][j]) return false;
            }
        }
        return true;
    }
}
