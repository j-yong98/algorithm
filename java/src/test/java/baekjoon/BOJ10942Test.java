package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10942Test {
    @Test
    void solution() throws IOException {
        BOJ10942 boj10942 = new BOJ10942();
        String p = "7\n" +
                "1 2 1 3 1 2 1\n" +
                "4\n" +
                "1 3\n" +
                "2 5\n" +
                "3 3\n" +
                "5 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10942.solution();
    }
}