package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11404Test {
    @Test
    void solution() throws IOException {
        BOJ11404 boj11404 = new BOJ11404();
        String p = "5\n" +
                "14\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "1 4 1\n" +
                "1 5 10\n" +
                "2 4 2\n" +
                "3 4 1\n" +
                "3 5 1\n" +
                "4 5 3\n" +
                "3 5 10\n" +
                "3 1 8\n" +
                "1 4 2\n" +
                "5 1 7\n" +
                "3 4 2\n" +
                "5 2 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11404.solution();
    }
}