package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5676Test {
    @Test
    void solution() throws IOException {
        BOJ5676 boj5676 = new BOJ5676();
        String p = "4 6\n" +
                "-2 6 0 -1\n" +
                "C 1 10\n" +
                "P 1 4\n" +
                "C 3 7\n" +
                "P 2 2\n" +
                "C 4 -5\n" +
                "P 1 4\n" +
                "5 9\n" +
                "1 5 -2 4 3\n" +
                "P 1 2\n" +
                "P 1 5\n" +
                "C 4 -5\n" +
                "P 1 5\n" +
                "P 4 5\n" +
                "C 3 0\n" +
                "P 1 5\n" +
                "C 4 -5\n" +
                "C 4 -5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5676.solution();
    }
}