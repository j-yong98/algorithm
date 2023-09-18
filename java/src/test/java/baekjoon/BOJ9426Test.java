package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9426Test {
    @Test
    void solution() throws IOException {
        BOJ9426 boj9426 = new BOJ9426();
        String p = "10 3\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9426.solution();
    }
}