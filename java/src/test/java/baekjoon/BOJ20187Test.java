package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20187Test {
    @Test
    void solution() throws IOException {
        BOJ20187 boj20187 = new BOJ20187();
        String p = "2\n" +
                "R D D R\n" +
                "3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20187.solution();
    }
}