package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1615Test {
    @Test
    void solution() throws IOException {
        BOJ1615 boj1615 = new BOJ1615();
        String p = "5 6\n" +
                "1 5\n" +
                "2 2\n" +
                "3 2\n" +
                "4 3\n" +
                "5 1\n" +
                "5 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1615.solution();
    }
}