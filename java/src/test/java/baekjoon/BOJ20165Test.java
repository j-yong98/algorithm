package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20165Test {
    @Test
    void solution() throws IOException {
        BOJ20165 boj20165 = new BOJ20165();
        String p = "5 5 3\n" +
                "1 1 1 1 1\n" +
                "1 2 2 1 1\n" +
                "3 1 2 2 2\n" +
                "1 3 2 1 1\n" +
                "1 3 3 1 1\n" +
                "3 1 E\n" +
                "3 5\n" +
                "5 3 N\n" +
                "3 3\n" +
                "5 2 N\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20165.solution();
    }
}