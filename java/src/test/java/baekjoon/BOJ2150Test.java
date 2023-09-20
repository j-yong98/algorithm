package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2150Test {
    @Test
    void solution() throws IOException {
        BOJ2150 boj2150 = new BOJ2150();
        String p = "7 9\n" +
                "1 4\n" +
                "4 5\n" +
                "5 1\n" +
                "1 6\n" +
                "6 7\n" +
                "2 7\n" +
                "7 3\n" +
                "3 7\n" +
                "7 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2150.solution();
    }
}