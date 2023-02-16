package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ12865Test {
    @Test
    void solution() throws IOException {
        BOJ12865 boj12865 = new BOJ12865();
        String p = "4 7\n" +
                "6 13\n" +
                "4 8\n" +
                "3 6\n" +
                "5 12";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12865.solution();
    }
}