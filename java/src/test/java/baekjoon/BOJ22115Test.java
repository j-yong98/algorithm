package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ22115Test {
    @Test
    void solution() throws IOException {
        BOJ22115 boj22115 = new BOJ22115();
        String p = "8 100\n" +
                "90 5 4 2 2 2 2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj22115.solution();
    }
}