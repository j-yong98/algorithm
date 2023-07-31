package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17478Test {
    @Test
    void solution() throws IOException {
        BOJ17478 boj17478 = new BOJ17478();
        String p = "4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17478.solution();
    }
}