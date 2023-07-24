package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3015Test {
    @Test
    void solution() throws IOException {
        BOJ3015 boj3015 = new BOJ3015();
        String p = "7\n" +
                "2\n" +
                "4\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "5\n" +
                "1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3015.solution();
    }
}