package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1753Test {
    @Test
    void solution() throws IOException {
        BOJ1753 boj1753 = new BOJ1753();
        String p = "5 6\n" +
                "1\n" +
                "5 1 1\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "2 3 4\n" +
                "2 4 5\n" +
                "3 4 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1753.solution();
    }
}