package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1788Test {
    @Test
    void solution() throws IOException {
        BOJ1788 boj1788 = new BOJ1788();
        String p = "10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1788.solution();
    }
}