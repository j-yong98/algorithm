package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1726Test {
    @Test
    void solution() throws IOException {
        BOJ1726 boj1726 = new BOJ1726();
        String p = "5 6\n" +
                "0 0 0 0 0 0\n" +
                "0 1 1 0 1 0\n" +
                "0 1 0 0 0 0\n" +
                "0 0 1 1 1 0\n" +
                "1 0 0 0 0 0\n" +
                "4 2 3\n" +
                "2 4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1726.solution();
    }
}