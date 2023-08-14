package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14728Test {
    @Test
    void solution() throws IOException {
        BOJ14728 boj14728 = new BOJ14728();
        String p = "3 310\n" +
                "50 40\n" +
                "100 70\n" +
                "200 150";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14728.solution();
    }
}