package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17779Test {
    @Test
    void solution() throws IOException {
        BOJ17779 boj17779 = new BOJ17779();
        String p = "14\n" +
                "65 1 33 1 1 1 14 1 1 1 1 1 100 1\n" +
                "1 32 1 43 1 71 1 1 1 1 41 1 1 1\n" +
                "1 1 75 1 81 17 1 1 15 1 1 31 1 12\n" +
                "1 1 100 1 1 1 13 1 1 1 13 1 1 1\n" +
                "20 1 1 1 1 1 1 1 99 1 1 1 1 1\n" +
                "1 1 1 1 1 1 1 79 1 14 1 1 1 1\n" +
                "1 30 1 1 1 1 1 1 1 1 10 1 1 1\n" +
                "1 34 1 1 1 77 1 1 1 1 10 1 1 1\n" +
                "1 1 1 100 1 1 1 51 21 100 1 10 1 1\n" +
                "8 1 1 1 88 1 1 1 13 1 1 1 1 1\n" +
                "1 1 100 1 1 1 31 1 1 1 1 100 1 1\n" +
                "1 9 1 1 100 1 1 1 1 1 100 1 1 1\n" +
                "1 2 1 1 1 1 100 1 1 1 1 1 1 1\n" +
                "3 100 55 1 1 1 100 100 1 1 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17779.solution();
    }
}