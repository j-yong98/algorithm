package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1168Test {
    @Test
    void solution() throws IOException {
        BOJ1168 boj1168 = new BOJ1168();
        String p = "7 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1168.solution();
    }
}