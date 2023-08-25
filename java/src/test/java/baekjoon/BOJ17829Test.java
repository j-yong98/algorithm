package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17829Test {
    @Test
    void solution() throws IOException {
        BOJ17829 boj17829 = new BOJ17829();
        String p = "8\n" +
                "-1 2 14 7 4 -5 8 9\n" +
                "10 6 23 2 -1 -1 7 11\n" +
                "9 3 5 -2 4 4 6 6\n" +
                "7 15 0 8 21 20 6 6\n" +
                "19 8 12 -8 4 5 2 9\n" +
                "1 2 3 4 5 6 7 8\n" +
                "9 10 11 12 13 14 15 16\n" +
                "17 18 19 20 21 22 23 24";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17829.solution();
    }
}