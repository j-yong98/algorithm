package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2302Test {
    @Test
    void solution() throws IOException {
        BOJ2302 boj2302 = new BOJ2302();
        String p = "9\n" +
                "2\n" +
                "4\n" +
                "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2302.solution();
    }
}