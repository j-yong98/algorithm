package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2174Test {
    @Test
    void solution() throws IOException {
        BOJ2174 boj2174 = new BOJ2174();
        String p = "5 4\n" +
                "2 2\n" +
                "1 1 E\n" +
                "5 4 W\n" +
                "1 F 7\n" +
                "2 F 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2174.solution();
    }
}