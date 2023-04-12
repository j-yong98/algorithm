package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17143Test {
    @Test
    void solution() throws IOException {
        BOJ17143 boj17143 = new BOJ17143();
        String p = "2 2 4\n" +
                "1 1 1 1 1\n" +
                "2 2 2 2 2\n" +
                "1 2 1 2 3\n" +
                "2 1 2 1 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17143.solution();
    }
}