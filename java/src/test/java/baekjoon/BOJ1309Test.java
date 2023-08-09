package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1309Test {
    @Test
    void solution() throws IOException {
        BOJ1309 boj1309 = new BOJ1309();
        String p = "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1309.solution();
    }
}