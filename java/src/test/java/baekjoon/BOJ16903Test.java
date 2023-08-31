package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16903Test {
    @Test
    void solution() throws IOException {
        BOJ16903 boj16903 = new BOJ16903();
        String p = "10\n" +
                "1 8\n" +
                "1 9\n" +
                "1 11\n" +
                "1 6\n" +
                "1 1\n" +
                "3 3\n" +
                "2 8\n" +
                "3 3\n" +
                "3 8\n" +
                "3 11";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16903.solution();
    }
}