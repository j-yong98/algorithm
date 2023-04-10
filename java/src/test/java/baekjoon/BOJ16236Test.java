package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16236Test {
    @Test
    void solution() throws IOException {
        BOJ16236 boj16236 = new BOJ16236();
        String p = "6\n" +
                "1 1 1 1 1 1\n" +
                "2 2 6 2 2 3\n" +
                "2 2 5 2 2 3\n" +
                "2 2 2 4 6 3\n" +
                "0 0 0 0 0 6\n" +
                "0 0 0 0 0 9";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16236.solution();
    }
}