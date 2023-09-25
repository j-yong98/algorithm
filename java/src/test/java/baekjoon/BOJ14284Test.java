package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14284Test {
    @Test
    void solution() throws IOException {
        BOJ14284 boj14284 = new BOJ14284();
        String p = "8 9\n" +
                "1 2 3\n" +
                "1 3 2\n" +
                "1 4 4\n" +
                "2 5 2\n" +
                "3 6 1\n" +
                "4 7 3\n" +
                "5 8 6\n" +
                "6 8 2\n" +
                "7 8 7\n" +
                "1 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14284.solution();
    }
}