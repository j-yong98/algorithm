package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2164Test {
    @Test
    void solution() throws IOException {
        BOJ2164 boj2164 = new BOJ2164();
        String p = "6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2164.solution();
    }
}