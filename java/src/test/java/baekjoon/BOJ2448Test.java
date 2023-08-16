package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2448Test {
    @Test
    void solution() throws IOException {
        BOJ2448 boj2448 = new BOJ2448();
        String p = "24";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2448.solution();
    }
}