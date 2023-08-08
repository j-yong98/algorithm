package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16926Test {
    @Test
    void solution() throws IOException {
        BOJ16926 boj16926 = new BOJ16926();
        String p = "5 4 7\n" +
                "1 2 3 4\n" +
                "7 8 9 10\n" +
                "13 14 15 16\n" +
                "19 20 21 22\n" +
                "25 26 27 28";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16926.solution();
    }
}