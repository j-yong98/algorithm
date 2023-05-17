package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11055Test {
    @Test
    void solution() throws IOException {
        BOJ11055 boj11055 = new BOJ11055();
        String p = "10\n" +
                "1 100 2 50 60 3 5 6 7 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11055.solution();
    }
}