package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13505Test {
    @Test
    void solution() throws IOException {
        BOJ13505 boj13505 = new BOJ13505();
        String p = "6\n" +
                "1 2 4 8 16 32";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13505.solution();
    }
}