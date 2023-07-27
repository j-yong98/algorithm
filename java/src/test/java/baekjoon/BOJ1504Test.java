package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1504Test {
    @Test
    void solution() throws IOException {
        BOJ1504 boj1504 = new BOJ1504();
        String p = "4 6\n" +
                "1 2 3\n" +
                "2 3 3\n" +
                "3 4 1\n" +
                "1 3 5\n" +
                "2 4 5\n" +
                "1 4 4\n" +
                "2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1504.solution();
    }
}