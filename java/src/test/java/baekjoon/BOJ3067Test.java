package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3067Test {
    @Test
    void solution() throws IOException {
        BOJ3067 boj3067 = new BOJ3067();
        String p = "3\n" +
                "2\n" +
                "1 2\n" +
                "1000\n" +
                "3\n" +
                "1 5 10\n" +
                "100\n" +
                "2\n" +
                "5 7\n" +
                "22";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3067.solution();
    }
}