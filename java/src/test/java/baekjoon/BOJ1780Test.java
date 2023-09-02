package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1780Test {
    @Test
    void solution() throws IOException {
        BOJ1780 boj1780 = new BOJ1780();
        String p = "9\n" +
                "0 0 0 1 1 1 -1 -1 -1\n" +
                "0 0 0 1 1 1 -1 -1 -1\n" +
                "0 0 0 1 1 1 -1 -1 -1\n" +
                "1 1 1 0 0 0 0 0 0\n" +
                "1 1 1 0 0 0 0 0 0\n" +
                "1 1 1 0 0 0 0 0 0\n" +
                "0 1 -1 0 1 -1 0 1 -1\n" +
                "0 -1 1 0 1 -1 0 1 -1\n" +
                "0 1 -1 1 0 -1 0 1 -1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1780.solution();
    }
}