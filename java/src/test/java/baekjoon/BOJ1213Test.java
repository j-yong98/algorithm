package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class BOJ1213Test {
    @Test
    void solution() {
        BOJ1213 boj1213 = new BOJ1213();
        String p = "ABACABA";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
    }
}