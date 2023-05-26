package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9655Test {
    @Test
    void solution() throws IOException {
        BOJ9655 boj9655 = new BOJ9655();
        String p = "11";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9655.solution();
    }
}