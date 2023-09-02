package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12837Test {
    @Test
    void solution() throws IOException {
        BOJ12837 boj12837 = new BOJ12837();
        String p = "10 6\n" +
                "1 3 10000\n" +
                "1 4 -5000\n" +
                "1 7 -3000\n" +
                "2 1 10\n" +
                "1 6 35000\n" +
                "2 4 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12837.solution();
    }
}