package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2146Test {
    @Test
    void solution() throws IOException {
        BOJ2146 boj2146 = new BOJ2146();
        String p = "5\n" +
                "0 0 0 0 0\n" +
                "0 0 1 0 0\n" +
                "0 1 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2146.solution();
    }
}