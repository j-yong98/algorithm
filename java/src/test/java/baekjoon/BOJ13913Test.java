package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13913Test {
    @Test
    void solution() throws IOException {
        BOJ13913 boj13913 = new BOJ13913();
        String p = "5 17";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13913.solution();
    }
}