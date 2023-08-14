package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10974Test {
    @Test
    void solution() throws IOException {
        BOJ10974 boj10974 = new BOJ10974();
        String p = "3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10974.solution();
    }
}