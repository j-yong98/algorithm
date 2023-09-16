package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11085Test {
    @Test
    void solution() throws IOException {
        BOJ11085 boj11085 = new BOJ11085();
        String p = "7 11\n" +
                "3 5\n" +
                "0 1 15\n" +
                "0 2 23\n" +
                "1 2 16\n" +
                "1 3 27\n" +
                "2 4 3\n" +
                "2 6 21\n" +
                "3 4 14\n" +
                "3 5 10\n" +
                "4 5 50\n" +
                "4 6 9\n" +
                "5 6 42";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11085.solution();
    }
}