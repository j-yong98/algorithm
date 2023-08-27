package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9372Test {
    @Test
    void solution() throws IOException {
        BOJ9372 boj9372 = new BOJ9372();
        String p = "2\n" +
                "3 3\n" +
                "1 2\n" +
                "2 3\n" +
                "1 3\n" +
                "5 4\n" +
                "2 1\n" +
                "2 3\n" +
                "4 3\n" +
                "4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9372.solution();
    }
}