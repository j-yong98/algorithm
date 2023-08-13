package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5347Test {
    @Test
    void solution() throws IOException {
        BOJ5347 boj5347 = new BOJ5347();
        String p = "3\n" +
                "15 21\n" +
                "33 22\n" +
                "9 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5347.solution();
    }
}