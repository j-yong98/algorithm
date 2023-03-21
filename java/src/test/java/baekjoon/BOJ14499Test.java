package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14499Test {
    @Test
    void solution() throws IOException {
        BOJ14499 boj14499 = new BOJ14499();
        String p = "3 3 0 0 16\n" +
                "0 1 2\n" +
                "3 4 5\n" +
                "6 7 8\n" +
                "4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14499.solution();
    }
}