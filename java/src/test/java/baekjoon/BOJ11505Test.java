package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11505Test {
    @Test
    void solution() throws IOException {
        BOJ11505 boj11505 = new BOJ11505();
        String p = "5 5 6\n" +
                "234235\n" +
                "34523\n" +
                "32425\n" +
                "76545\n" +
                "976566\n" +
                "2 1 5\n" +
                "1 4 999999\n" +
                "2 1 5\n" +
                "1 5 999999\n" +
                "2 1 5\n" +
                "1 3 999999\n" +
                "2 1 5\n" +
                "1 2 999999\n" +
                "2 1 5\n" +
                "1 1 999999\n" +
                "2 1 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11505.solution();
    }
}