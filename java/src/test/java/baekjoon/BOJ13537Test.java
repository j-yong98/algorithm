package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13537Test {
    @Test
    void solution() throws IOException {
        BOJ13537 boj13537 = new BOJ13537();
        String p = "5\n" +
                "5 1 2 3 4\n" +
                "3\n" +
                "2 4 1\n" +
                "4 4 4\n" +
                "1 5 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13537.solution();
    }
}