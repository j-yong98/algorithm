package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14925Test {
    @Test
    void solution() throws IOException {
        BOJ14925 boj14925 = new BOJ14925();
        String p = "6 6\n" +
                "0 0 0 1 0 0\n" +
                "0 0 0 2 1 0\n" +
                "0 0 2 0 0 0\n" +
                "0 1 0 0 0 0\n" +
                "2 0 0 0 0 0\n" +
                "0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14925.solution();
    }
}