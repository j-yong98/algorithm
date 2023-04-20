package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6198Test {
    @Test
    void solution() throws IOException {
        BOJ6198 boj6198 = new BOJ6198();
        String p = "6\n" +
                "10\n" +
                "3\n" +
                "7\n" +
                "4\n" +
                "12\n" +
                "2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6198.solution();
    }
}