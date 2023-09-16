package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3653Test {
    @Test
    void solution() throws IOException {
        BOJ3653 boj3653 = new BOJ3653();
        String p = "2\n" +
                "3 3\n" +
                "3 1 1\n" +
                "5 3\n" +
                "4 4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3653.solution();
    }
}