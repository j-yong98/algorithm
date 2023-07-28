package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1966Test {
    @Test
    void solution() throws IOException {
        BOJ1966 boj1966 = new BOJ1966();
        String p = "3\n" +
                "1 0\n" +
                "5\n" +
                "4 2\n" +
                "1 2 3 4\n" +
                "6 0\n" +
                "1 1 9 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1966.solution();
    }
}