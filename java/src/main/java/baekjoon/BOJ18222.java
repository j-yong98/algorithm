package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18222 {
    long K;
    /**
     * 투에-모스 문자열
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Long.parseLong(br.readLine());
        System.out.println(getCharAt(K));
        br.close();
    }

    private int getCharAt(long k) {
        if (k == 1) return 0;
        long i;
        for (i = 1; i + i < k; i += i);
        return 1 - getCharAt(k - i);
    }
}
