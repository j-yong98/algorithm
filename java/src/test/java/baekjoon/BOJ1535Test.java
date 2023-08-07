package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1535Test {
    @Test
    void solution() throws IOException {
        BOJ1535 boj1535 = new BOJ1535();
        String p = "4\n" +
                "100 50 20 13\n" +
                "20 30 40 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1535.solution();
    }
}