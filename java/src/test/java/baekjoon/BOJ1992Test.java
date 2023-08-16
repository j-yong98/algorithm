package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1992Test {
    @Test
    void solution() throws IOException {
        BOJ1992 boj1992 = new BOJ1992();
        String p = "8\n" +
                "11110000\n" +
                "11110000\n" +
                "00011100\n" +
                "00011100\n" +
                "11110000\n" +
                "11110000\n" +
                "11110011\n" +
                "11110011";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1992.solution();
    }
}