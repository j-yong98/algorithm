package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ18116Test {
    @Test
    void solution() throws IOException {
        BOJ18116 boj18116 = new BOJ18116();
        String p = "4\n" +
                "I 1 2\n" +
                "I 3 2\n" +
                "Q 1\n" +
                "Q 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj18116.solution();
    }
}