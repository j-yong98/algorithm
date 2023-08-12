package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20542Test {
    @Test
    void solution() throws IOException {
        BOJ20542 boj20542 = new BOJ20542();
        String p = "5 8\n" +
                "taken\n" +
                "fishcake";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20542.solution();
    }
}