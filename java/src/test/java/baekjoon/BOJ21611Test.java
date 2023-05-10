package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21611Test {
    @Test
    void solution() throws IOException {
        BOJ21611 boj21611 = new BOJ21611();
        String p = "7 7\n" +
                "1 1 1 2 2 2 3\n" +
                "1 2 2 1 2 2 3\n" +
                "1 3 3 2 3 1 2\n" +
                "1 2 2 0 3 2 2\n" +
                "3 1 2 2 3 2 2\n" +
                "3 1 2 1 1 2 1\n" +
                "3 1 2 2 2 1 1\n" +
                "1 3\n" +
                "2 2\n" +
                "3 1\n" +
                "4 3\n" +
                "1 3\n" +
                "1 1\n" +
                "1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21611.solution();
    }
}