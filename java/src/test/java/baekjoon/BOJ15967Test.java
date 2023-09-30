package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15967Test {
    @Test
    void solution() throws IOException {
        BOJ15967 boj15967 = new BOJ15967();
        String p = "4 2 3\n" +
                "1 2 3 4\n" +
                "1 1 4\n" +
                "2 1 4 5\n" +
                "1 1 4\n" +
                "2 1 1 -10000\n" +
                "1 1 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15967.solution();
    }
}