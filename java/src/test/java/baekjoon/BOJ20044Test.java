package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20044Test {
    @Test
    void solution() throws IOException {
        BOJ20044 boj20044 = new BOJ20044();
        String p = "3\n" +
                "1 7 3 5 9 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20044.solution();
    }
}