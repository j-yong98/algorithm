package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2156Test {
    @Test
    void solution() throws IOException {
        BOJ2156 boj2156 = new BOJ2156();
        String p = "6\n" +
                "6\n" +
                "10\n" +
                "13\n" +
                "9\n" +
                "8\n" +
                "1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2156.solution();
    }
}