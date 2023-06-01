package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2240Test {
    @Test
    void solution() throws IOException {
        BOJ2240 boj2240 = new BOJ2240();
        String p = "7 2\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "1\n" +
                "1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2240.solution();
    }
}