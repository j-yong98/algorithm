package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10999Test {
    @Test
    void solution() throws IOException {
        BOJ10999 boj10999 = new BOJ10999();
        String p = "5 2 2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "1 3 4 6\n" +
                "2 2 5\n" +
                "1 1 3 -2\n" +
                "2 2 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10999.solution();
    }
}