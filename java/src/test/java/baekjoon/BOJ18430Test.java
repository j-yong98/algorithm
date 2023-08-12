package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18430Test {
    @Test
    void solution() throws IOException {
        BOJ18430 boj18430 = new BOJ18430();
        String p = "3 3\n" +
                "32 83 75\n" +
                "24 96 56\n" +
                "71 88 12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18430.solution();
    }
}