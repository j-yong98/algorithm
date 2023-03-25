package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3190Test {
    @Test
    void solution() throws IOException {
        BOJ3190 boj3190 = new BOJ3190();
        String p = "10\n" +
                "5\n" +
                "1 5\n" +
                "1 3\n" +
                "1 2\n" +
                "1 6\n" +
                "1 7\n" +
                "4\n" +
                "8 D\n" +
                "10 D\n" +
                "11 D\n" +
                "13 L";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3190.solution();
    }
}