package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2529Test {
    @Test
    void solution() throws IOException {
        BOJ2529 boj2529 = new BOJ2529();
        String p = "9\n" +
                "> < < < > > > < <";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2529.solution();
    }
}