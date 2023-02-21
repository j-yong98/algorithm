package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ10156Test {
    @Test
    void solution() throws IOException {
        BOJ10156 boj10156 = new BOJ10156();
        String p = "20 10 320";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10156.solution();
    }
}