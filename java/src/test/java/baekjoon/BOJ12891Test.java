package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12891Test {
    @Test
    void solution() throws IOException {
        BOJ12891 boj12891 = new BOJ12891();
        String p = "4 2\n" +
                "GATA\n" +
                "1 0 0 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12891.solution();
    }
}