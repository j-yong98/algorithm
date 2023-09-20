package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5419Test {
    @Test
    void solution() throws IOException {
        BOJ5419 boj5419 = new BOJ5419();
        String p = "2\n" +
                "4\n" +
                "-10 -10\n" +
                "-10 10\n" +
                "10 -10\n" +
                "10 10\n" +
                "3\n" +
                "1 3\n" +
                "2 2\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5419.solution();
    }
}