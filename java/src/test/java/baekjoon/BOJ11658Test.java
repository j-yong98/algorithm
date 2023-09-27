package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11658Test {
    @Test
    void solution() throws IOException {
        BOJ11658 boj11658 = new BOJ11658();
        String p = "4 5\n" +
                "1 2 3 4\n" +
                "2 3 4 5\n" +
                "3 4 5 6\n" +
                "4 5 6 7\n" +
                "1 2 2 3 4\n" +
                "0 2 3 7\n" +
                "1 2 2 3 4\n" +
                "0 3 4 5\n" +
                "1 3 4 3 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11658.solution();
    }
}