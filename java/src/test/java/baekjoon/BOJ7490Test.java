package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7490Test {
    @Test
    void solution() throws IOException {
        BOJ7490 boj7490 = new BOJ7490();
        String p = "2\n" +
                "3\n" +
                "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7490.solution();
    }
}