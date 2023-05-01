package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ19236Test {
    @Test
    void solution() throws IOException {
        BOJ19236 boj19236 = new BOJ19236();
        String p = "12 6 14 5 4 5 6 7\n" +
                "15 1 11 7 3 7 7 5\n" +
                "10 3 8 3 16 6 1 1\n" +
                "5 8 2 7 13 6 9 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19236.solution();
    }
}