package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3040Test {
    @Test
    void solution() throws IOException {
        BOJ3040 boj3040 = new BOJ3040();
        String p = "7\n" +
                "8\n" +
                "10\n" +
                "13\n" +
                "15\n" +
                "19\n" +
                "20\n" +
                "23\n" +
                "25";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3040.solution();
    }
}