package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1495Test {
    @Test
    void solution() throws IOException {
        BOJ1495 boj1495 = new BOJ1495();
        String p = "14 40 243\n" +
                "74 39 127 95 63 140 99 96 154 18 137 162 14 88";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1495.solution();
    }
}