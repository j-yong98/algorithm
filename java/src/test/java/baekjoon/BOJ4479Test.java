package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4479Test {
    @Test
    void solution() throws IOException {
        BOJ4479 boj4479 = new BOJ4479();
        String p = "0\n" +
                "1\n" +
                "3\n" +
                "2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4479.solution();
    }
}