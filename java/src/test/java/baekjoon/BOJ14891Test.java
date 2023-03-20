package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14891Test {
    @Test
    void solution() throws IOException {
        BOJ14891 boj14891 = new BOJ14891();
        String p = "10010011\n" +
                "01010011\n" +
                "11100011\n" +
                "01010101\n" +
                "8\n" +
                "1 1\n" +
                "2 1\n" +
                "3 1\n" +
                "4 1\n" +
                "1 -1\n" +
                "2 -1\n" +
                "3 -1\n" +
                "4 -1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14891.solution();
    }
}