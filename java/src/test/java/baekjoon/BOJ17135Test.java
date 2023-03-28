package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17135Test {
    @Test
    void solution() throws IOException {
        BOJ17135 boj17135 = new BOJ17135();
        String p = "6 5 2\n" +
                "1 0 1 0 1\n" +
                "0 1 0 1 0\n" +
                "1 1 0 0 0\n" +
                "0 0 0 1 1\n" +
                "1 1 0 1 1\n" +
                "0 0 1 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17135.solution();
    }
}