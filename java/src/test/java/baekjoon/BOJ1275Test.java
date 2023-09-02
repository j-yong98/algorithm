package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1275Test {
    @Test
    void solution() throws IOException {
        BOJ1275 boj1275 = new BOJ1275();
        String p = "5 2\n" +
                "1 2 3 4 5\n" +
                "2 3 3 1\n" +
                "3 5 4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1275.solution();
    }
}