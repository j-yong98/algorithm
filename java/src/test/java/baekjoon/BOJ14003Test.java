package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14003Test {
    @Test
    void solution() throws IOException {
        BOJ14003 boj14003 = new BOJ14003();
        String p = "6\n" +
                "10 20 10 30 20 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14003.solution();
    }
}