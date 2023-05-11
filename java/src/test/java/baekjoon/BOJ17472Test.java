package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ17472Test {

    @Test
    void solution() throws IOException {
        BOJ17472 boj17472 = new BOJ17472();
        String p = "7 8\n" +
                "0 0 0 1 1 0 0 0\n" +
                "0 0 0 1 1 0 0 0\n" +
                "1 1 0 0 0 0 1 1\n" +
                "1 1 0 0 0 0 1 1\n" +
                "1 1 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0\n" +
                "1 1 1 1 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17472.solution();
    }
}