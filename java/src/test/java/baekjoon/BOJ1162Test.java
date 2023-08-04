package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1162Test {
    @Test
    void solution() throws IOException {
        BOJ1162 boj1162 = new BOJ1162();
        String p = "4 4 1\n" +
                "1 2 10\n" +
                "2 4 10\n" +
                "1 3 1\n" +
                "3 4 100";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1162.solution();
    }
}