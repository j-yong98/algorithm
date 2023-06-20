package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13549Test {
    @Test
    void solution() throws IOException {
        BOJ13549 boj13549 = new BOJ13549();
        String p = "5 17";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13549.solution();
    }
}