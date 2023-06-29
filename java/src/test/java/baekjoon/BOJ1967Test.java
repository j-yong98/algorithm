package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1967Test {
    @Test
    void solution() throws IOException {
        BOJ1967 boj1967 = new BOJ1967();
        String p = "5\n" +
                "1 2 100\n" +
                "1 3 100\n" +
                "2 4 100\n" +
                "3 5 100";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1967.solution();
    }
}