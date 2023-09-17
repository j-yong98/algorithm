package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9345Test {
    @Test
    void solution() throws IOException {
        BOJ9345 boj9345 = new BOJ9345();
        String p = "2\n" +
                "5 8\n" +
                "1 0 4\n" +
                "1 1 2\n" +
                "0 1 3\n" +
                "1 2 2\n" +
                "1 1 3\n" +
                "1 0 0\n" +
                "1 0 2\n" +
                "1 2 4\n" +
                "5 5\n" +
                "0 1 2\n" +
                "0 2 3\n" +
                "0 1 3\n" +
                "1 0 1\n" +
                "1 0 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9345.solution();
    }
}