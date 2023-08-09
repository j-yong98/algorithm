package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16935Test {
    @Test
    void solution() throws IOException {
        BOJ16935 boj16935 = new BOJ16935();
        String p = "6 8 6\n" +
                "3 2 6 3 1 2 9 7\n" +
                "9 7 8 2 1 4 5 3\n" +
                "5 9 2 1 9 6 1 8\n" +
                "2 1 3 8 6 3 9 2\n" +
                "1 3 2 8 7 9 2 1\n" +
                "4 5 1 9 8 2 1 3\n" +
                "1 2 3 4 5 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16935.solution();
    }
}