package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ6549Test {
    @Test
    void solution() throws IOException {
        BOJ6549 boj6549 = new BOJ6549();
        String p = "7 2 1 4 5 1 3 3\n" +
                "4 1000 1000 1000 1000\n" +
                "0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj6549.solution();
    }
}