package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ23288Test {
    @Test
    void solution() throws IOException {
        BOJ23288 boj23288 = new BOJ23288();
        String p = "4 5 1000\n" +
                "4 1 2 3 3\n" +
                "6 1 1 3 3\n" +
                "5 6 1 3 2\n" +
                "5 5 6 5 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj23288.solution();
    }
}