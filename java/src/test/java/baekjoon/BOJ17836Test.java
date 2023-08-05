package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17836Test {
    @Test
    void solution() throws IOException {
        BOJ17836 boj17836 = new BOJ17836();
        String p = "6 6 16\n" +
                "0 0 0 0 1 1\n" +
                "0 0 0 0 0 2\n" +
                "1 1 1 0 1 0\n" +
                "0 0 0 0 0 0\n" +
                "0 1 1 1 1 1\n" +
                "0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17836.solution();
    }
}