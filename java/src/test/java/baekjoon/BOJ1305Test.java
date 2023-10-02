package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1305Test {
    @Test
    void solution() throws IOException {
        BOJ1305 boj1305 = new BOJ1305();
        String p = "5\n" +
                "aaaaa";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1305.solution();
    }
}