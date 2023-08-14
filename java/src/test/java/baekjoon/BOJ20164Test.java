package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20164Test {
    @Test
    void solution() throws IOException {
        BOJ20164 boj20164 = new BOJ20164();
        String p = "999999999";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20164.solution();
    }
}