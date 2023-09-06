package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16948Test {
    @Test
    void solution() throws IOException {
        BOJ16948 boj16948 = new BOJ16948();
        String p = "7\n" +
                "6 6 0 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16948.solution();
    }
}