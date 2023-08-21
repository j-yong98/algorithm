package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1766Test {
    @Test
    void solution() throws IOException {
        BOJ1766 boj1766 = new BOJ1766();
        String p = "4 2\n" +
                "4 2\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1766.solution();
    }
}