package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16637Test {
    @Test
    void solution() throws IOException {
        BOJ16637 boj16637 = new BOJ16637();
        String p = "5\n" +
                "8*3+5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16637.solution();
    }
}