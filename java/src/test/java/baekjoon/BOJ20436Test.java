package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20436Test {
    @Test
    void solution() throws IOException {
        BOJ20436 boj20436 = new BOJ20436();
        String p = "z o\n" +
                "zoac";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20436.solution();
    }
}