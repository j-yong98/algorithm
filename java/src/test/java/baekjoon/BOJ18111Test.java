package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18111Test {
    @Test
    void solution() throws IOException {
        BOJ18111 boj18111 = new BOJ18111();
        String p = "3 4 0\n" +
                "64 64 64 64\n" +
                "64 64 64 64\n" +
                "64 64 64 63";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18111.solution();
    }
}