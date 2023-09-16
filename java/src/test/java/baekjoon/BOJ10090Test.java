package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10090Test {
    @Test
    void solution() throws IOException {
        BOJ10090 boj10090 = new BOJ10090();
        String p = "7\n" +
                "4 2 7 1 5 6 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10090.solution();
    }
}