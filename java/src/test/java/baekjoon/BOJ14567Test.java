package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14567Test {
    @Test
    void solution() throws IOException {
        BOJ14567 boj14567 = new BOJ14567();
        String p = "6 4\n" +
                "1 2\n" +
                "1 3\n" +
                "2 5\n" +
                "4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14567.solution();
    }
}