package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20922Test {
    @Test
    void solution() throws IOException {
        BOJ20922 boj20922 = new BOJ20922();
        String p = "9 2\n" +
                "3 2 5 5 6 4 4 5 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20922.solution();
    }
}