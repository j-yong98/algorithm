package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4883Test {
    @Test
    void solution() throws IOException {
        BOJ4883 boj4883 = new BOJ4883();
        String p = "3\n" +
                "1 1 1\n" +
                "1 1 1\n" +
                "-1 1 1\n" +
                "0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4883.solution();
    }
}