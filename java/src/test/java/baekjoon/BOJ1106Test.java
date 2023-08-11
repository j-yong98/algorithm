package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1106Test {
    @Test
    void solution() throws IOException {
        BOJ1106 boj1106 = new BOJ1106();
        String p = "10 10\n" +
                "1 1\n" +
                "2 2\n" +
                "3 3\n" +
                "4 4\n" +
                "5 5\n" +
                "6 6\n" +
                "7 7\n" +
                "8 8\n" +
                "9 9\n" +
                "10 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1106.solution();
    }
}