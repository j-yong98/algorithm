package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13458Test {
    @Test
    void solution() throws IOException {
        BOJ13458 boj13458 = new BOJ13458();
        String p = "5\n" +
                "1000000 1000000 1000000 1000000 1000000\n" +
                "5 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13458.solution();
    }
}