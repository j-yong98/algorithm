package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2573Test {
    @Test
    void solution() throws IOException {
        BOJ2573 boj2573 = new BOJ2573();
        String p = "5 7\n" +
                "0 0 0 0 0 0 0\n" +
                "0 2 4 5 3 0 0\n" +
                "0 3 0 2 5 2 0\n" +
                "0 7 6 2 4 0 0\n" +
                "0 0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2573.solution();
    }

}