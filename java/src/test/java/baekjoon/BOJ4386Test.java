package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4386Test {
    @Test
    void solution() throws IOException {
        BOJ4386 boj4386 = new BOJ4386();
        String p = "3\n" +
                "1.0 1.0\n" +
                "2.0 2.0\n" +
                "2.0 4.0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4386.solution();
    }
}