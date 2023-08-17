package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20546Test {
    @Test
    void solution() throws IOException {
        BOJ20546 boj20546 = new BOJ20546();
        String p = "100\n" +
                "10 20 23 34 55 30 22 19 12 45 23 44 34 38";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20546.solution();
    }
}