package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1948Test {
    @Test
    void solution() throws IOException {
        BOJ1948 boj1948 = new BOJ1948();
        String p = "7\n" +
                "9\n" +
                "1 2 4\n" +
                "1 3 2\n" +
                "1 4 3\n" +
                "2 6 3\n" +
                "2 7 5\n" +
                "3 5 1\n" +
                "4 6 4\n" +
                "5 6 2\n" +
                "6 7 5\n" +
                "1 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1948.solution();
    }
}