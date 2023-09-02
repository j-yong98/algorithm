package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1517Test {
    @Test
    void solution() throws IOException {
        BOJ1517 boj1517 = new BOJ1517();
        String p = "3\n" +
                "3 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1517.solution();
    }
}