package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1777Test {
    @Test
    void solution() throws IOException {
        BOJ1777 boj1777 = new BOJ1777();
        String p = "8\n" +
                "0 1 0 2 2 1 2 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1777.solution();
    }
}