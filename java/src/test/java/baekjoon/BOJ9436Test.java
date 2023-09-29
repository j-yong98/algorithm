package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9436Test {
    @Test
    void solution() throws IOException {
        BOJ9436 boj9436 = new BOJ9436();
        String p = "3\n" +
                "5\n" +
                "2 5 4 1 3\n" +
                "1 5 3 2 4\n" +
                "7\n" +
                "5 6 7 1 2 3 4\n" +
                "5 6 7 1 2 3 4\n" +
                "7\n" +
                "1 5 3 4 2 7 6\n" +
                "7 1 5 3 4 2 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9436.solution();
    }
}