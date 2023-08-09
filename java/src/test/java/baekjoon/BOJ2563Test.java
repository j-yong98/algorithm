package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2563Test {
    @Test
    void solution() throws IOException {
        BOJ2563 boj2563 = new BOJ2563();
        String p = "3\n" +
                "3 7\n" +
                "15 7\n" +
                "5 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2563.solution();
    }
}