package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
    StringBuilder sb = new StringBuilder();
    int N;
    /**
     * 별 찍기 10
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                star(i, j, N);
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private void star(int y, int x, int n) {
        if ((y / n) % 3 == 1 && (x / n) % 3 == 1) sb.append(" ");
        else if (n / 3 == 0) sb.append("*");
        else star(y, x, n / 3);
    }
}
