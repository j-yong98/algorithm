package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2638Test {
    @Test
    void solution() throws IOException {
        BOJ2638 boj2638 = new BOJ2638();
        String p = "8 9\n" +
                "0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 1 1 0 0 0 0\n" +
                "0 0 0 1 1 0 1 1 0\n" +
                "0 0 1 1 1 1 1 1 0\n" +
                "0 0 1 1 1 1 1 0 0\n" +
                "0 0 1 1 0 1 1 0 0\n" +
                "0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2638.solution();
    }
}