package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14463Test {
    @Test
    void solution() throws IOException {
        BOJ14463 boj14463 = new BOJ14463();
        String p = "4\n" +
                "3\n" +
                "2\n" +
                "4\n" +
                "4\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14463.solution();
    }
}