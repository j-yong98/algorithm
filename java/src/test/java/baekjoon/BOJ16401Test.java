package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16401Test {
    @Test
    void solution() throws IOException {
        BOJ16401 boj16401 = new BOJ16401();
        String p = "3 10\n" +
                "1 2 3 4 5 6 7 8 9 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16401.solution();
    }
}