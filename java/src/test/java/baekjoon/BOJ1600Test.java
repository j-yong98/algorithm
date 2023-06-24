package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1600Test {
    @Test
    void solution() throws IOException {
        BOJ1600 boj1600 = new BOJ1600();
        String p = "2\n" +
                "5 2\n" +
                "0 0 1 1 0\n" +
                "0 0 1 1 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1600.solution();
    }
}