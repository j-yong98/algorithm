package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2194Test {
    @Test
    void solution() throws IOException {
        BOJ2194 boj2194 = new BOJ2194();
        String p = "5 5 2 2 3\n" +
                "2 2\n" +
                "3 2\n" +
                "3 3\n" +
                "4 1\n" +
                "1 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2194.solution();
    }
}