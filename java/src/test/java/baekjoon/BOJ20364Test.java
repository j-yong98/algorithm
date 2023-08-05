package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20364Test {
    @Test
    void solution() throws IOException {
        BOJ20364 boj20364 = new BOJ20364();
        String p = "6 4\n" +
                "3\n" +
                "5\n" +
                "6\n" +
                "2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20364.solution();
    }
}