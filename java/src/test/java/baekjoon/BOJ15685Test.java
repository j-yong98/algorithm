package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15685Test {
    @Test
    void solution() throws IOException {
        BOJ15685 boj15685 = new BOJ15685();
        String p = "3\n" +
                "3 3 0 1\n" +
                "4 2 1 3\n" +
                "4 2 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15685.solution();
    }
}