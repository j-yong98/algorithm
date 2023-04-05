package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2493Test {
    @Test
    void solution() throws IOException {
        BOJ2493 boj2493 = new BOJ2493();
        String p = "5\n" +
                "6 9 5 7 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2493.solution();
    }
}