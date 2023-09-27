package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3006Test {
    @Test
    void solution() throws IOException {
        BOJ3006 boj3006 = new BOJ3006();
        String p = "7\n" +
                "5\n" +
                "4\n" +
                "3\n" +
                "7\n" +
                "1\n" +
                "2\n" +
                "6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3006.solution();
    }
}