package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7511Test {
    @Test
    void solution() throws IOException {
        BOJ7511 boj7511 = new BOJ7511();
        String p = "2\n" +
                "3\n" +
                "1\n" +
                "0 1\n" +
                "2\n" +
                "0 1\n" +
                "1 2\n" +
                "5\n" +
                "3\n" +
                "0 1\n" +
                "1 2\n" +
                "3 4\n" +
                "2\n" +
                "0 2\n" +
                "1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7511.solution();
    }
}