package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1976Test {
    @Test
    void solution() throws IOException {
        BOJ1976 boj1976 = new BOJ1976();
        String p = "3\n" +
                "3\n" +
                "0 1 0\n" +
                "1 0 1\n" +
                "0 1 0\n" +
                "1 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1976.solution();
    }
}