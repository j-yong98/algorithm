package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2230Test {
    @Test
    void solution() throws IOException {
        BOJ2230 boj2230 = new BOJ2230();
        String p = "3 3\n" +
                "1\n" +
                "5\n" +
                "3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2230.solution();
    }
}