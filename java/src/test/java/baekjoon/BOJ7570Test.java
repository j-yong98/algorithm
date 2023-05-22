package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7570Test {
    @Test
    void solution() throws IOException {
        BOJ7570 boj7570 = new BOJ7570();
        String p = "5\n" +
                "5 2 4 1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7570.solution();
    }
}