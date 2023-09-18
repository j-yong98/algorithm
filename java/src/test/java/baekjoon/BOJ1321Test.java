package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1321Test {
    @Test
    void solution() throws IOException {
        BOJ1321 boj1321 = new BOJ1321();
        String p = "5\n" +
                "1 4 3 5 2\n" +
                "5\n" +
                "1 2 -3\n" +
                "1 4 2\n" +
                "2 5\n" +
                "1 2 4\n" +
                "2 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1321.solution();
    }
}