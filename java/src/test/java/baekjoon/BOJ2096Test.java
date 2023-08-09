package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2096Test {
    @Test
    void solution() throws IOException {
        BOJ2096 boj2096 = new BOJ2096();
        String p = "3\n" +
                "1 2 3\n" +
                "4 5 6\n" +
                "4 9 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2096.solution();
    }
}