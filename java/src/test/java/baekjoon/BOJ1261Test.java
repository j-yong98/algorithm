package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1261Test {
    @Test
    void solution() throws IOException {
        BOJ1261 boj1261 = new BOJ1261();
        String p = "6 6\n" +
                "001111\n" +
                "010000\n" +
                "001111\n" +
                "110001\n" +
                "011010\n" +
                "100010";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1261.solution();
    }
}