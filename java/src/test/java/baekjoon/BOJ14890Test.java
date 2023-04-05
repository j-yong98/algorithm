package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14890Test {
    @Test
    void solution() throws IOException {
        BOJ14890 boj14890 = new BOJ14890();
        String p = "6 1\n" +
                "3 2 1 1 2 3\n" +
                "3 2 2 1 2 3\n" +
                "3 2 2 2 3 3\n" +
                "3 3 3 3 3 3\n" +
                "3 3 3 3 2 2\n" +
                "3 3 3 3 2 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14890.solution();
    }
}