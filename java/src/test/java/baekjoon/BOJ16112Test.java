package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16112Test {
    @Test
    void solution() throws IOException {
        BOJ16112 boj16112 = new BOJ16112();
        String p = "3 2\n" +
                "100 300 200";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16112.solution();
    }
}