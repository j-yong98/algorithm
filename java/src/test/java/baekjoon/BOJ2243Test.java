package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2243Test {
    @Test
    void solution() throws IOException {
        BOJ2243 boj2243 = new BOJ2243();
        String p = "6\n" +
                "2 1 2\n" +
                "2 3 3\n" +
                "1 2\n" +
                "1 2\n" +
                "2 1 -1\n" +
                "1 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2243.solution();
    }
}