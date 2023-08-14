package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1717Test {
    @Test
    void solution() throws IOException {
        BOJ1717 boj1717 = new BOJ1717();
        String p = "7 8\n" +
                "0 1 3\n" +
                "1 1 7\n" +
                "0 7 6\n" +
                "1 7 1\n" +
                "0 3 7\n" +
                "0 4 2\n" +
                "0 1 1\n" +
                "1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1717.solution();
    }
}