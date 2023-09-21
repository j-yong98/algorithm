package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1854Test {
    @Test
    void solution() throws IOException {
        BOJ1854 boj1854 = new BOJ1854();
        String p = "5 10 2\n" +
                "1 2 2\n" +
                "1 3 7\n" +
                "1 4 5\n" +
                "1 5 6\n" +
                "2 4 2\n" +
                "2 3 4\n" +
                "3 4 6\n" +
                "3 5 8\n" +
                "5 2 4\n" +
                "5 4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1854.solution();
    }
}