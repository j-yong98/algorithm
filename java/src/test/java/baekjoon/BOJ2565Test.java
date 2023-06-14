package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2565Test {
    @Test
    void solution() throws IOException {
        BOJ2565 boj2565 = new BOJ2565();
        String p = "8\n" +
                "1 8\n" +
                "3 9\n" +
                "2 2\n" +
                "4 1\n" +
                "6 4\n" +
                "10 10\n" +
                "9 7\n" +
                "7 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2565.solution();
    }
}