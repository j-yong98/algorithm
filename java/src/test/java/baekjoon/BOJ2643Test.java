package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2643Test {
    @Test
    void solution() throws IOException {
        BOJ2643 boj2643 = new BOJ2643();
        String p = "10\n" +
                "3 49\n" +
                "7 30\n" +
                "6 45\n" +
                "15 19\n" +
                "8 41\n" +
                "18 23\n" +
                "14 33\n" +
                "15 34\n" +
                "28 31\n" +
                "47 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2643.solution();
    }
}