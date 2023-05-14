package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7795Test {
    @Test
    void solution() throws IOException {
        BOJ7795 boj7795 = new BOJ7795();
        String p = "2\n" +
                "5 3\n" +
                "8 1 7 3 1\n" +
                "3 6 1\n" +
                "3 4\n" +
                "2 13 7\n" +
                "103 11 290 215";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7795.solution();
    }
}