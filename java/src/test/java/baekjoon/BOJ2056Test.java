package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2056Test {
    @Test
    void solution() throws IOException {
        BOJ2056 boj2056 = new BOJ2056();
        String p = "7\n" +
                "5 0\n" +
                "1 1 1\n" +
                "3 1 2\n" +
                "6 1 1\n" +
                "1 2 2 4\n" +
                "8 2 2 4\n" +
                "4 3 3 5 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2056.solution();
    }
}