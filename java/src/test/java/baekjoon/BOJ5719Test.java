package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5719Test {
    @Test
    void solution() throws IOException {
        BOJ5719 boj5719 = new BOJ5719();
        String p = "7 9\n" +
                "0 6\n" +
                "0 1 1\n" +
                "0 2 1\n" +
                "0 3 2\n" +
                "0 4 3\n" +
                "1 5 2\n" +
                "2 6 4\n" +
                "3 6 2\n" +
                "4 6 4\n" +
                "5 6 1\n" +
                "4 6\n" +
                "0 2\n" +
                "0 1 1\n" +
                "1 2 1\n" +
                "1 3 1\n" +
                "3 2 1\n" +
                "2 0 3\n" +
                "3 0 2\n" +
                "6 8\n" +
                "0 1\n" +
                "0 1 1\n" +
                "0 2 2\n" +
                "0 3 3\n" +
                "2 5 3\n" +
                "3 4 2\n" +
                "4 1 1\n" +
                "5 1 1\n" +
                "3 0 1\n" +
                "0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5719.solution();
    }
}