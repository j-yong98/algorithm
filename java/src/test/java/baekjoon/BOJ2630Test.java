package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2630Test {
    @Test
    void solution() throws IOException {
        BOJ2630 boj2630 = new BOJ2630();
        String p = "8\n" +
                "1 1 0 0 0 0 1 1\n" +
                "1 1 0 0 0 0 1 1\n" +
                "0 0 0 0 1 1 0 0\n" +
                "0 0 0 0 1 1 0 0\n" +
                "1 0 0 0 1 1 1 1\n" +
                "0 1 0 0 1 1 1 1\n" +
                "0 0 1 1 1 1 1 1\n" +
                "0 0 1 1 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2630.solution();
    }
}