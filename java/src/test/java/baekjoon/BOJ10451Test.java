package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10451Test {
    @Test
    void solution() throws IOException {
        BOJ10451 boj10451 = new BOJ10451();
        String p = "2\n" +
                "8\n" +
                "3 2 7 8 1 4 5 6\n" +
                "10\n" +
                "2 1 3 4 5 6 7 9 10 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10451.solution();
    }
}