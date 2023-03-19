package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17141Test {
    @Test
    void solution() throws IOException {
        BOJ17141 boj17141 = new BOJ17141();
        String p = "5 1\n" +
                "2 2 2 1 1\n" +
                "2 1 1 1 1\n" +
                "2 1 1 1 1\n" +
                "2 1 1 1 1\n" +
                "2 2 2 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17141.solution();
    }
}