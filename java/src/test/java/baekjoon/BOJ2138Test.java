package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2138Test {
    @Test
    void solution() throws IOException {
        BOJ2138 boj2138 = new BOJ2138();
        String p = "3\n" +
                "000\n" +
                "010";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2138.solution();
    }
}