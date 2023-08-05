package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ24511Test {
    @Test
    void solution() throws IOException {
        BOJ24511 boj24511 = new BOJ24511();
        String p = "4\n" +
                "0 1 1 0\n" +
                "1 2 3 4\n" +
                "3\n" +
                "2 4 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj24511.solution();
    }
}