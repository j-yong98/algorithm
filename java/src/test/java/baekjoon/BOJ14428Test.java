package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14428Test {
    @Test
    void solution() throws IOException {
        BOJ14428 boj14428 = new BOJ14428();
        String p = "5\n" +
                "5 4 3 2 1\n" +
                "6\n" +
                "2 1 3\n" +
                "2 1 4\n" +
                "1 5 3\n" +
                "2 3 5\n" +
                "1 4 3\n" +
                "2 3 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14428.solution();
    }
}