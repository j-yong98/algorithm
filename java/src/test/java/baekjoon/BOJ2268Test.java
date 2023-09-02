package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2268Test {
    @Test
    void solution() throws IOException {
        BOJ2268 boj2268 = new BOJ2268();
        String p = "3 5\n" +
                "0 1 3\n" +
                "1 1 2\n" +
                "1 2 3\n" +
                "0 2 3\n" +
                "0 1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2268.solution();
    }
}