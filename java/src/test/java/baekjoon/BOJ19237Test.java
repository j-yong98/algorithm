package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class BOJ19237Test {
    @Test
    void solution() throws Exception {
        BOJ19237 boj19237 = new BOJ19237();
        String p = "4 2 6\n" +
                "1 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 2\n" +
                "4 3\n" +
                "1 2 3 4\n" +
                "2 3 4 1\n" +
                "3 4 1 2\n" +
                "4 1 2 3\n" +
                "1 2 3 4\n" +
                "2 3 4 1\n" +
                "3 4 1 2\n" +
                "4 1 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19237.solution();
    }
}