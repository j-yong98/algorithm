package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1253Test {
    @Test
    void solution() throws IOException {
        BOJ1253 boj1253 = new BOJ1253();
        String p = "10\n" +
                "1 2 3 4 5 6 7 8 9 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1253.solution();
    }
}