package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15666Test {
    @Test
    void solution() throws IOException {
        BOJ15666 boj15666 = new BOJ15666();
        String p = "4 4\n" +
                "1 1 2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15666.solution();
    }
}