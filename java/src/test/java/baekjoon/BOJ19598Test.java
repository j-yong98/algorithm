package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ19598Test {
    @Test
    void solution() throws IOException {
        BOJ19598 boj19598 = new BOJ19598();
        String p = "4\n" +
                "1 2\n" +
                "1 4\n" +
                "2 6\n" +
                "4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19598.solution();
    }
}