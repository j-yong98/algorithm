package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11048Test {
    @Test
    void solution() throws IOException {
        BOJ11048 boj11048 = new BOJ11048();
        String p = "4 3\n" +
                "1 2 3\n" +
                "6 5 4\n" +
                "7 8 9\n" +
                "12 11 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11048.solution();
    }
}