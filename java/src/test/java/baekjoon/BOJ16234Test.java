package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16234Test {
    @Test
    void solution() throws IOException {
        BOJ16234 boj16234 = new BOJ16234();
        String p = "4 10 50\n" +
                "10 100 20 90\n" +
                "80 100 60 70\n" +
                "70 20 30 40\n" +
                "50 20 100 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16234.solution();
    }
}