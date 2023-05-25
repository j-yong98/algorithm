package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11727Test {
    @Test
    void solution() throws IOException {
        BOJ11727 boj11727 = new BOJ11727();
        String p = "8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11727.solution();
    }
}