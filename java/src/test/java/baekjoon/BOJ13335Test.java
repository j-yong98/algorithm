package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13335Test {
    @Test
    void solution() throws IOException {
        BOJ13335 boj13335 = new BOJ13335();
        String p = "10 100 100\n" +
                "10 10 10 10 10 10 10 10 10 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13335.solution();
    }
}