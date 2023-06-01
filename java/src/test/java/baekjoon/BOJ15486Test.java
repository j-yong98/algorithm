package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15486Test {
    @Test
    void solution() throws IOException {
        BOJ15486 boj15486 = new BOJ15486();
        String p = "10\n" +
                "5 50\n" +
                "4 40\n" +
                "3 30\n" +
                "2 20\n" +
                "1 10\n" +
                "1 10\n" +
                "2 20\n" +
                "3 30\n" +
                "4 40\n" +
                "5 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15486.solution();
    }
}