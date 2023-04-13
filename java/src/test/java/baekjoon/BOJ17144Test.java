package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17144Test {
    @Test
    void solution() throws IOException {
        BOJ17144 boj17144 = new BOJ17144();
        String p = "7 8 50\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17144.solution();
    }
}