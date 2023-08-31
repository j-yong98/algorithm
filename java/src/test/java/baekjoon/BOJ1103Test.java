package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1103Test {
    @Test
    void solution() throws IOException {
        BOJ1103 boj1103 = new BOJ1103();
        String p = "3 7\n" +
                "3942178\n" +
                "1234567\n" +
                "9123532";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1103.solution();
    }
}