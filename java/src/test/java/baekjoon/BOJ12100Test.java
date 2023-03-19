package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12100Test {
    @Test
    void solution() throws IOException {
        BOJ12100 boj12100 = new BOJ12100();
        String p = "4\n" +
                "0 64 2 1024\n" +
                "2 512 8 0\n" +
                "0 32 512 256\n" +
                "64 64 8 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12100.solution();
    }
}