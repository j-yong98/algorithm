package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5904Test {
    @Test
    void solution() throws IOException {
        BOJ5904 boj5904 = new BOJ5904();
        String p = "11";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5904.solution();
    }
}