package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14620Test {
    @Test
    void solution() throws IOException {
        BOJ14620 boj14620 = new BOJ14620();
        String p = "6\n" +
                "1 0 2 3 3 4\n" +
                "1 1 1 1 1 1\n" +
                "0 0 1 1 1 1\n" +
                "3 9 9 0 1 99\n" +
                "9 11 3 1 0 3\n" +
                "12 3 0 0 0 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14620.solution();
    }
}