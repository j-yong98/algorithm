package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9934Test {
    @Test
    void solution() throws IOException {
        BOJ9934 boj9934 = new BOJ9934();
        String p = "3\n" +
                "1 6 4 3 5 2 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9934.solution();
    }
}