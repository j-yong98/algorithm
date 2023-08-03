package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6064Test {
    @Test
    void solution() throws IOException {
        BOJ6064 boj6064 = new BOJ6064();
        String p = "3\n" +
                "10 12 3 9\n" +
                "10 12 7 2\n" +
                "13 11 5 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6064.solution();
    }
}