package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2800Test {
    @Test
    void solution() throws IOException {
        BOJ2800 boj2800 = new BOJ2800();
        String p = "(1+(2*(3+4)))";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2800.solution();
    }
}