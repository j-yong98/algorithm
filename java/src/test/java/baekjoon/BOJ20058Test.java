package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20058Test {
    @Test
    void solution() throws IOException {
        BOJ20058 boj20058 = new BOJ20058();
        String p = "3 10\n" +
                "1 2 3 4 5 6 7 8\n" +
                "8 7 6 5 4 3 2 1\n" +
                "1 2 3 4 5 6 7 8\n" +
                "8 7 6 5 4 3 2 1\n" +
                "1 2 3 4 5 6 7 8\n" +
                "8 7 6 5 4 3 2 1\n" +
                "1 2 3 4 5 6 7 8\n" +
                "8 7 6 5 4 3 2 1\n" +
                "1 2 3 1 2 3 1 2 3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20058.solution();
    }
}