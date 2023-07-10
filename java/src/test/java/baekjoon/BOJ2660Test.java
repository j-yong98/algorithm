package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2660Test {
    @Test
    void solution() throws IOException {
        BOJ2660 boj2660 = new BOJ2660();
        String p = "5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "2 4\n" +
                "5 3\n" +
                "-1 -1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2660.solution();
    }
}