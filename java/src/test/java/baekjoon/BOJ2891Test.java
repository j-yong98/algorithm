package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2891Test {
    @Test
    void solution() throws IOException {
        BOJ2891 boj2891 = new BOJ2891();
        String p = "4 2 2\n" +
                "2 4\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2891.solution();
    }
}