package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1707Test {
    @Test
    void solution() throws IOException {
        BOJ1707 boj1707 = new BOJ1707();
        String p = "2\n" +
                "3 2\n" +
                "1 3\n" +
                "2 3\n" +
                "4 4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1707.solution();
    }
}