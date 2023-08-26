package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14923Test {
    @Test
    void solution() throws IOException {
        BOJ14923 boj14923 = new BOJ14923();
        String p = "5 6\n" +
                "1 1\n" +
                "5 6\n" +
                "0 1 1 1 0 0\n" +
                "0 1 1 0 0 0\n" +
                "0 1 0 0 1 0\n" +
                "0 1 0 0 1 0\n" +
                "0 0 0 1 1 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14923.solution();
    }
}