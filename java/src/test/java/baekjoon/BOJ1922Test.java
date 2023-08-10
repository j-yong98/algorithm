package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1922Test {
    @Test
    void solution() throws IOException {
        BOJ1922 boj1922 = new BOJ1922();
        String p = "6\n" +
                "9\n" +
                "1 2 5\n" +
                "1 3 4\n" +
                "2 3 2\n" +
                "2 4 7\n" +
                "3 4 6\n" +
                "3 5 11\n" +
                "4 5 3\n" +
                "4 6 8\n" +
                "5 6 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1922.solution();
    }
}