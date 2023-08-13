package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1758Test {
    @Test
    void solution() throws IOException {
        BOJ1758 boj1758 = new BOJ1758();
        String p = "3\n" +
                "1\n" +
                "2\n" +
                "3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1758.solution();
    }
}