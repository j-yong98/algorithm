package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3986Test {
    @Test
    void solution() throws IOException {
        BOJ3986 boj3986 = new BOJ3986();
        String p = "1\n" +
                "ABBABB";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3986.solution();
    }
}