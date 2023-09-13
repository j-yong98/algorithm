package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13306Test {
    @Test
    void solution() throws IOException {
        BOJ13306 boj13306 = new BOJ13306();
        String p = "11 5\n" +
                "7\n" +
                "4\n" +
                "1\n" +
                "9\n" +
                "11\n" +
                "1\n" +
                "11\n" +
                "1\n" +
                "3\n" +
                "7\n" +
                "0 11\n" +
                "1 8 5\n" +
                "1 3 9\n" +
                "0 10\n" +
                "0 9\n" +
                "0 7\n" +
                "1 2 7\n" +
                "0 5\n" +
                "1 1 10\n" +
                "0 8\n" +
                "0 6\n" +
                "0 2\n" +
                "1 1 3\n" +
                "0 3\n" +
                "0 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13306.solution();
    }
}