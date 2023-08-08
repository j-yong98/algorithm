package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1644Test {
    @Test
    void solution() throws IOException {
        BOJ1644 boj1644 = new BOJ1644();
        String p = "41";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1644.solution();
    }
}