package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ19942Test {
    @Test
    void solution() throws IOException {
        BOJ19942 boj19942 = new BOJ19942();
        String p = "6\n" +
                "100 70 90 10\n" +
                "30 55 10 8 100\n" +
                "60 10 10 2 70\n" +
                "10 80 50 0 50\n" +
                "40 30 30 8 60\n" +
                "60 10 70 2 120\n" +
                "20 70 50 4 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19942.solution();
    }
}