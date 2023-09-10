package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15681Test {
    @Test
    void solution() throws IOException {
        BOJ15681 boj15681 = new BOJ15681();
        String p = "9 5 3\n" +
                "1 3\n" +
                "4 3\n" +
                "5 4\n" +
                "5 6\n" +
                "6 7\n" +
                "2 3\n" +
                "9 6\n" +
                "6 8\n" +
                "5\n" +
                "4\n" +
                "8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15681.solution();
    }
}