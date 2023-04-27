package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ21610Test {
    @Test
    void solution() throws IOException {
        BOJ21610 boj21610 = new BOJ21610();
        String p = "5 8\n" +
                "100 100 100 100 100\n" +
                "100 100 100 100 100\n" +
                "100 100 100 100 100\n" +
                "100 100 100 100 100\n" +
                "100 100 100 100 100\n" +
                "8 1\n" +
                "7 1\n" +
                "6 1\n" +
                "5 1\n" +
                "4 1\n" +
                "3 1\n" +
                "2 1\n" +
                "1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj21610.solution();
    }
}