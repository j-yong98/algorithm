package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1005Test {
    @Test
    void solution() throws IOException {
        BOJ1005 boj1005 = new BOJ1005();
        String p = "2\n" +
                "4 4\n" +
                "10 1 100 10\n" +
                "1 2\n" +
                "1 3\n" +
                "2 4\n" +
                "3 4\n" +
                "4\n" +
                "8 8\n" +
                "10 20 1 5 8 7 1 43\n" +
                "1 2\n" +
                "1 3\n" +
                "2 4\n" +
                "2 5\n" +
                "3 6\n" +
                "5 7\n" +
                "6 7\n" +
                "7 8\n" +
                "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1005.solution();
    }
}