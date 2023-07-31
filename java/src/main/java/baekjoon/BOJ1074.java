package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    int N, r, c;
    int cnt = 0;
    /**
     * Z
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        Z(0, 0, 1 << N);
        br.close();
    }

    private void Z(int y, int x, int size) {
        if (y == r && x == c) {
            System.out.println(cnt);
            return;
        }
        if (size == 1) {
            cnt++;
            return;
        }
        if (!inRange(y, x, size)) {
            cnt += size * size;
            return;
        }
        int next = size >> 1;
        Z(y, x, next);
        Z(y, x + next, next);
        Z(y + next, x, next);
        Z(y + next, x + next, next);
    }

    private boolean inRange(int y, int x, int n) {
        return r >= y && r < y + n && c >= x && c < x + n;
    }
}
