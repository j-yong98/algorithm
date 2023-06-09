package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1793Test {
    @Test
    void solution() throws IOException {
        BOJ1793 boj1793 = new BOJ1793();
        String p = "2\n" +
                "8\n" +
                "12\n" +
                "100\n" +
                "200";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1793.solution();
    }
}