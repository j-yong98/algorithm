package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14245Test {
    @Test
    void solution() throws IOException {
        BOJ14245 boj14245 = new BOJ14245();
        String p = "5\n" +
                "1 2 3 4 5\n" +
                "6\n" +
                "1 0 4 9\n" +
                "2 0\n" +
                "2 1\n" +
                "2 2\n" +
                "2 3\n" +
                "2 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14245.solution();
    }
}