package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16920Test {
    @Test
    void solution() throws IOException {
        BOJ16920 boj16920 = new BOJ16920();
        String p = "5 10 4\n" +
                "1 2 1 2\n" +
                "1........2\n" +
                ".....44...\n" +
                "......4...\n" +
                "2.........\n" +
                "....3.....";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16920.solution();
    }
}