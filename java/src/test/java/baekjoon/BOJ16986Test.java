package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16986Test {
    @Test
    void solution() throws IOException {
        BOJ16986 boj16986 = new BOJ16986();
        String p = "9 6\n" +
                "1 2 2 0 0 2 2 0 2\n" +
                "0 1 0 2 0 2 0 2 2\n" +
                "0 2 1 0 0 0 0 0 2\n" +
                "2 0 2 1 0 0 2 2 2\n" +
                "2 2 2 2 1 0 2 2 2\n" +
                "0 0 2 2 2 1 2 2 0\n" +
                "0 2 2 0 0 0 1 2 0\n" +
                "2 0 2 0 0 0 0 1 0\n" +
                "0 0 0 0 0 2 2 2 1\n" +
                "4 8 6 1 2 3 3 7 6 4 4 9 9 3 6 7 6 4 1 1\n" +
                "3 8 9 7 9 8 6 3 8 7 1 6 2 3 6 5 8 5 1 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16986.solution();
    }
}