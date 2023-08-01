package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2447Test {
    @Test
    void solution() throws IOException {
        BOJ2447 boj2447 = new BOJ2447();
        String p = "9";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2447.solution();
    }
}