package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15565Test {
    @Test
    void solution() throws IOException {
        BOJ15565 boj15565 = new BOJ15565();
        String p = "10 3\n" +
                "1 2 2 2 1 2 1 2 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15565.solution();
    }
}