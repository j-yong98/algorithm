package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14427Test {
    @Test
    void solution() throws IOException {
        BOJ14427 boj14427 = new BOJ14427();
        String p = "5\n" +
                "5 4 3 2 1\n" +
                "5\n" +
                "2\n" +
                "1 5 3\n" +
                "2\n" +
                "1 4 3\n" +
                "2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14427.solution();
    }
}