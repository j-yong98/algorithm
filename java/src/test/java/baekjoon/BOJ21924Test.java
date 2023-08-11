package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21924Test {
    @Test
    void solution() throws IOException {
        BOJ21924 boj21924 = new BOJ21924();
        String p = "8 10\n" +
                "1 2 4\n" +
                "2 3 9\n" +
                "2 4 9\n" +
                "3 4 4\n" +
                "3 5 1\n" +
                "4 6 14\n" +
                "6 7 5\n" +
                "5 7 3\n" +
                "7 8 7\n" +
                "6 8 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21924.solution();
    }
}