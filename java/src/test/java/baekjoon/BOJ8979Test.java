package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ8979Test {
    @Test
    void solution() throws IOException {
        BOJ8979 boj8979 = new BOJ8979();
        String p = "4 3\n" +
                "1 1 2 0\n" +
                "2 0 1 0\n" +
                "3 0 1 0\n" +
                "4 0 0 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj8979.solution();
    }
}