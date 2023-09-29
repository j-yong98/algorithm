package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4375Test {
    @Test
    void solution() throws IOException {
        BOJ4375 boj4375 = new BOJ4375();
        String p = "3\n" +
                "7\n" +
                "9901";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4375.solution();
    }
}