package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17086Test {
    @Test
    void solution() throws IOException {
        BOJ17086 boj17086 = new BOJ17086();
        String p = "5 4\n" +
                "0 0 1 0\n" +
                "0 0 0 0\n" +
                "1 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17086.solution();
    }
}