package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1629Test {
    @Test
    void solution() throws IOException {
        BOJ1629 boj1629 = new BOJ1629();
        String p = "10 11 12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1629.solution();
    }
}