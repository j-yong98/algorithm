package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17281Test {
    @Test
    void solution() throws IOException {
        BOJ17281 boj17281 = new BOJ17281();
        String p = "9\n" +
                "1 2 4 3 0 2 1 0 3\n" +
                "1 2 1 2 0 0 0 0 1\n" +
                "3 4 2 3 1 2 3 4 0\n" +
                "0 1 2 3 4 2 1 0 0\n" +
                "0 0 0 0 0 0 1 4 4\n" +
                "0 4 0 4 0 4 0 4 0\n" +
                "0 4 2 2 2 2 2 2 2\n" +
                "1 1 1 1 1 1 1 1 0\n" +
                "0 2 0 3 0 1 0 2 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17281.solution();
    }
}