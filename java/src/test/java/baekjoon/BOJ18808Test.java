package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18808Test {
    @Test
    void solution() throws IOException {
        BOJ18808 boj18808 = new BOJ18808();
        String p = "8 6 6\n" +
                "3 5\n" +
                "0 1 0 0 0\n" +
                "1 1 1 1 1\n" +
                "0 1 0 0 1\n" +
                "6 3\n" +
                "0 0 1\n" +
                "0 0 1\n" +
                "0 0 1\n" +
                "1 1 1\n" +
                "1 0 1\n" +
                "1 1 1\n" +
                "6 3\n" +
                "1 1 0\n" +
                "1 0 0\n" +
                "1 1 1\n" +
                "1 0 1\n" +
                "1 0 0\n" +
                "1 0 0\n" +
                "6 6\n" +
                "0 0 0 0 1 0\n" +
                "0 0 1 0 1 0\n" +
                "0 0 1 0 1 0\n" +
                "0 1 1 1 1 0\n" +
                "0 1 1 0 1 1\n" +
                "1 1 1 0 0 0\n" +
                "4 5\n" +
                "0 0 0 0 1\n" +
                "1 0 0 1 1\n" +
                "1 1 1 1 0\n" +
                "1 1 0 1 0\n" +
                "4 3\n" +
                "1 1 0\n" +
                "1 0 0\n" +
                "1 1 1\n" +
                "1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18808.solution();
    }
}