package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2623Test {
    @Test
    void solution() throws IOException {
        BOJ2623 boj2623 = new BOJ2623();
        String p = "6 3\n" +
                "3 1 4 3\n" +
                "4 6 2 5 4\n" +
                "2 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2623.solution();
    }
}