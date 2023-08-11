package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6497Test {
    @Test
    void solution() throws IOException {
        BOJ6497 boj6497 = new BOJ6497();
        String p = "7 11\n" +
                "0 1 7\n" +
                "0 3 5\n" +
                "1 2 8\n" +
                "1 3 9\n" +
                "1 4 7\n" +
                "2 4 5\n" +
                "3 4 15\n" +
                "3 5 6\n" +
                "4 5 8\n" +
                "4 6 9\n" +
                "5 6 11\n" +
                "0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6497.solution();
    }
}