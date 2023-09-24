package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1719Test {
    @Test
    void solution() throws IOException {
        BOJ1719 boj1719 = new BOJ1719();
        String p = "6 10\n" +
                "1 2 2\n" +
                "1 3 1\n" +
                "2 4 5\n" +
                "2 5 3\n" +
                "2 6 7\n" +
                "3 4 4\n" +
                "3 5 6\n" +
                "3 6 7\n" +
                "4 6 4\n" +
                "5 6 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1719.solution();
    }
}