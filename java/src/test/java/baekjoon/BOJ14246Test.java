package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14246Test {
    @Test
    void solution() throws IOException {
        BOJ14246 boj14246 = new BOJ14246();
        String p = "5\n" +
                "1 2 3 2 1\n" +
                "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14246.solution();
    }

}