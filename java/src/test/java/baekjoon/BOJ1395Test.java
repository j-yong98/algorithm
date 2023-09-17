package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1395Test {
    @Test
    void solution() throws IOException {
        BOJ1395 boj1395 = new BOJ1395();
        String p = "4 5\n" +
                "0 1 2\n" +
                "0 2 4\n" +
                "1 2 3\n" +
                "0 2 4\n" +
                "1 1 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1395.solution();
    }
}