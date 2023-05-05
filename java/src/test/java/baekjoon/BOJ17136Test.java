package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17136Test {
    @Test
    void solution() throws IOException {
        BOJ17136 boj17136 = new BOJ17136();
        String p = "0 0 0 0 0 0 0 0 0 0\n" +
                "0 1 1 1 1 1 0 0 0 0\n" +
                "0 1 1 1 1 1 0 0 0 0\n" +
                "0 0 1 1 1 1 0 0 0 0\n" +
                "0 0 1 1 1 1 0 0 0 0\n" +
                "0 1 1 1 1 1 1 1 1 1\n" +
                "0 1 1 1 0 1 1 1 1 1\n" +
                "0 1 1 1 0 1 1 1 1 1\n" +
                "0 0 0 0 0 1 1 1 1 1\n" +
                "0 0 0 0 0 1 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17136.solution();
    }
}