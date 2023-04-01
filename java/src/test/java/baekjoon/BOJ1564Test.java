package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1564Test {
    @Test
    void solution() throws IOException {
        BOJ1564 boj1564 = new BOJ1564();
        String p = "9050";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1564.solution();
    }
}