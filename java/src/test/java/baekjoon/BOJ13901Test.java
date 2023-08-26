package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ13901Test {
    @Test
    void solution() throws IOException {
        BOJ13901 boj13901 = new BOJ13901();
        String p = "3 3\n" +
                "1\n" +
                "1 0\n" +
                "1 1\n" +
                "1 2 3 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj13901.solution();
    }
}