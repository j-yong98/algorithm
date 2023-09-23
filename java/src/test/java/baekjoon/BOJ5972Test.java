package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5972Test {
    @Test
    void solution() throws IOException {
        BOJ5972 boj5972 = new BOJ5972();
        String p = "6 8\n" +
                "4 5 3\n" +
                "2 4 0\n" +
                "4 1 4\n" +
                "2 1 1\n" +
                "5 6 1\n" +
                "3 6 2\n" +
                "3 2 6\n" +
                "3 4 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5972.solution();
    }
}