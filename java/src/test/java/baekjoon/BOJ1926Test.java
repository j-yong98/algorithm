package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1926Test {
    @Test
    void solution() throws IOException {
        BOJ1926 boj1926 = new BOJ1926();
        String p = "6 5\n" +
                "1 1 0 1 1\n" +
                "0 1 1 0 0\n" +
                "0 0 0 0 0\n" +
                "1 0 1 1 1\n" +
                "0 0 1 1 1\n" +
                "0 0 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1926.solution();
    }
}