package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1932Test {
    @Test
    void solution() throws IOException {
        BOJ1932 boj1932 = new BOJ1932();
        String p = "5\n" +
                "7\n" +
                "3 8\n" +
                "8 1 0\n" +
                "2 7 4 4\n" +
                "4 5 2 6 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1932.solution();
    }
}