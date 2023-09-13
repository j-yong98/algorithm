package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2104Test {
    @Test
    void solution() throws IOException {
        BOJ2104 boj2104 = new BOJ2104();
        String p = "6\n" +
                "3 1 6 4 5 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2104.solution();
    }
}