package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4256Test {
    @Test
    void solution() throws IOException {
        BOJ4256 boj4256 = new BOJ4256();
        String p = "2\n" +
                "4\n" +
                "3 2 1 4\n" +
                "2 3 4 1\n" +
                "8\n" +
                "3 6 5 4 8 7 1 2\n" +
                "5 6 8 4 3 1 2 7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4256.solution();
    }
}