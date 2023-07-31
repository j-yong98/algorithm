package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1074Test {
    @Test
    void solution() throws IOException {
        BOJ1074 boj1074 = new BOJ1074();
        String p = "10 511 511";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1074.solution();
    }
}