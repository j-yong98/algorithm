package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2559Test {
    @Test
    void solution() throws IOException {
        BOJ2559 boj2559 = new BOJ2559();
        String p = "10 2\n" +
                "3 -2 -4 -9 0 3 7 13 8 -3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2559.solution();
    }
}