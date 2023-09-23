package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ26146Test {
    @Test
    void solution() throws IOException {
        BOJ26146 boj26146 = new BOJ26146();
        String p = "4 5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 1\n" +
                "1 4\n" +
                "4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj26146.solution();
    }
}