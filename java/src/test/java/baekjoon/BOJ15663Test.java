package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15663Test {
    @Test
    void solution() throws IOException {
        BOJ15663 boj15663 = new BOJ15663();
        String p = "4 2\n" +
                "9 7 9 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15663.solution();
    }
}