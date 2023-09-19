package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3770Test {
    @Test
    void solution() throws IOException {
        BOJ3770 boj3770 = new BOJ3770();
        String p = "1\n" +
                "3 4 4\n" +
                "1 4\n" +
                "2 3\n" +
                "3 2\n" +
                "3 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3770.solution();
    }
}