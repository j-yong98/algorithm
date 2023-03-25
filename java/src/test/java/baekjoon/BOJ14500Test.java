package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14500Test {
    @Test
    void solution() throws IOException {
        BOJ14500 boj14500 = new BOJ14500();
        String p = "4 4\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 1 2 3\n" +
                "0 0 4 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14500.solution();
    }
}