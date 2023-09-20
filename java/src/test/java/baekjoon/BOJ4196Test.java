package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4196Test {
    @Test
    void solution() throws IOException {
        BOJ4196 boj4196 = new BOJ4196();
        String p = "1\n" +
                "3 2\n" +
                "1 2\n" +
                "2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4196.solution();
    }
}