package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14940Test {
    @Test
    void solution() throws IOException {
        BOJ14940 boj14940 = new BOJ14940();
        String p = "15 15\n" +
                "2 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 0 0 0 0 1\n" +
                "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1 1 0 1 0 0 0\n" +
                "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14940.solution();
    }
}