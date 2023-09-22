package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15678Test {
    @Test
    void solution() throws IOException {
        BOJ15678 boj15678 = new BOJ15678();
        String p = "3 2\n" +
                "-4 -2 -7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15678.solution();
    }
}