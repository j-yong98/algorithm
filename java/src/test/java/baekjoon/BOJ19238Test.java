package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ19238Test {
    @Test
    void solution() throws IOException {
        BOJ19238 boj19238 = new BOJ19238();
        String p = "6 3 15\n" +
                "0 0 1 0 0 0\n" +
                "0 0 1 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 1 0\n" +
                "0 0 0 1 0 0\n" +
                "6 5\n" +
                "2 2 5 6\n" +
                "5 4 1 6\n" +
                "4 2 3 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19238.solution();
    }
}