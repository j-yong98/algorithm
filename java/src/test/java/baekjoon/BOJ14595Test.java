package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14595Test {
    @Test
    void solution() throws IOException {
        BOJ14595 boj14595 = new BOJ14595();
        String p = "10\n" +
                "3\n" +
                "1 3\n" +
                "2 4\n" +
                "5 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14595.solution();
    }
}