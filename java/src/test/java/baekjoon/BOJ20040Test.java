package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20040Test {
    @Test
    void solution() throws IOException {
        BOJ20040 boj20040 = new BOJ20040();
        String p = "6 5\n" +
                "0 1\n" +
                "1 2\n" +
                "1 3\n" +
                "0 3\n" +
                "4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20040.solution();
    }
}