package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2042Test {
    @Test
    void solution() throws IOException {
        BOJ2042 boj2042 = new BOJ2042();
        String p = "5 2 2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "1 3 6\n" +
                "2 2 5\n" +
                "1 5 2\n" +
                "2 3 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2042.solution();
    }
}