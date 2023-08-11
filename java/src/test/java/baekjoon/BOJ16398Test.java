package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16398Test {
    @Test
    void solution() throws IOException {
        BOJ16398 boj16398 = new BOJ16398();
        String p = "3\n" +
                "0 2 3\n" +
                "2 0 1\n" +
                "3 1 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16398.solution();
    }
}