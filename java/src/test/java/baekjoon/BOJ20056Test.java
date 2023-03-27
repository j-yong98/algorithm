package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20056Test {
    @Test
    void solution() throws IOException {
        BOJ20056 boj20056 = new BOJ20056();
        String p = "7 5 3\n" +
                "1 3 5 2 4\n" +
                "2 3 5 2 6\n" +
                "5 2 9 1 7\n" +
                "6 2 1 3 5\n" +
                "4 4 2 4 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20056.solution();
    }
}