package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9370Test {
    @Test
    void solution() throws IOException {
        BOJ9370 boj9370 = new BOJ9370();
        String p = "2\n" +
                "5 4 2\n" +
                "1 2 3\n" +
                "1 2 6\n" +
                "2 3 2\n" +
                "3 4 4\n" +
                "3 5 3\n" +
                "5\n" +
                "4\n" +
                "6 9 2\n" +
                "2 3 1\n" +
                "1 2 1\n" +
                "1 3 3\n" +
                "2 4 4\n" +
                "2 5 5\n" +
                "3 4 3\n" +
                "3 6 2\n" +
                "4 5 4\n" +
                "4 6 3\n" +
                "5 6 7\n" +
                "5\n" +
                "6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9370.solution();
    }
}