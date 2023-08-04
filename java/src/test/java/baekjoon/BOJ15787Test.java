package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15787Test {
    @Test
    void solution() throws IOException {
        BOJ15787 boj15787 = new BOJ15787();
        String p = "5 5\n" +
                "1 1 1\n" +
                "1 1 2\n" +
                "1 2 2\n" +
                "1 2 3\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15787.solution();
    }
}