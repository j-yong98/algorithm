package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14727Test {
    @Test
    void solution() throws IOException {
        BOJ14727 boj14727 = new BOJ14727();
        String p = "3\n" +
                "7\n" +
                "3\n" +
                "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14727.solution();
    }
}