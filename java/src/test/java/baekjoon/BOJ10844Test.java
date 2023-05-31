package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10844Test {
    @Test
    void solution() throws IOException {
        BOJ10844 boj10844 = new BOJ10844();
        String p = "3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10844.solution();
    }
}