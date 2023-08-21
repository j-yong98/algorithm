package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2252Test {
    @Test
    void solution() throws IOException {
        BOJ2252 boj2252 = new BOJ2252();
        String p = "4 2\n" +
                "4 2\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2252.solution();
    }
}