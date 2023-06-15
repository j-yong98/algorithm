package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10476Test {
    @Test
    void solution() throws IOException {
        BOJ10476 boj10476 = new BOJ10476();
        String p = "10 5\n" +
                "7 8\n" +
                "4 9\n" +
                "3 7\n" +
                "5 9\n" +
                "7 2\n" +
                "10 3\n" +
                "0 10\n" +
                "3 2\n" +
                "6 3\n" +
                "7 9\n" +
                "0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10476.solution();
    }
}