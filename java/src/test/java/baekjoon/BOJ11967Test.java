package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11967Test {
    @Test
    void solution() throws IOException {
        BOJ11967 boj11967 = new BOJ11967();
        String p = "5 25\n" +
                "5 3 4 3\n" +
                "1 1 1 3\n" +
                "1 3 2 2\n" +
                "4 2 4 3\n" +
                "1 1 1 2\n" +
                "1 4 3 5\n" +
                "5 1 3 1\n" +
                "5 3 5 2\n" +
                "4 3 4 5\n" +
                "5 4 3 1\n" +
                "5 4 3 4\n" +
                "3 4 5 4\n" +
                "3 3 4 3\n" +
                "3 3 1 5\n" +
                "1 2 2 1\n" +
                "4 5 3 1\n" +
                "1 4 3 3\n" +
                "4 5 1 3\n" +
                "2 1 5 1\n" +
                "3 5 5 1\n" +
                "2 1 1 4\n" +
                "4 3 5 4\n" +
                "1 3 2 3\n" +
                "3 3 5 2\n" +
                "1 2 3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11967.solution();
    }
}