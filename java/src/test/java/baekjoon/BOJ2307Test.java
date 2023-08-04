package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2307Test {
    @Test
    void solution() throws IOException {
        BOJ2307 boj2307 = new BOJ2307();
        String p = "6 7\n" +
                "1 2 1\n" +
                "1 4 3\n" +
                "3 6 1\n" +
                "4 5 1\n" +
                "2 3 2\n" +
                "3 4 1\n" +
                "5 6 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2307.solution();
    }
}