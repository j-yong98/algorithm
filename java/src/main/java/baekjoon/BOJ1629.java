package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    long a, b, c;
    /**
     * 곱셈
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(rec(a, b, c));
        br.close();
    }

    private long rec(long x, long y, long z) {
        if (y == 0) return 1;
        if (y == 1) return x % z;
        if (y % 2 == 1) return rec(x, y - 1, z) * x % z;
        return rec(x * x % z, y / 2, z);
    }
}
