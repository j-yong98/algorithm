package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ3745Test {
    @Test
    void solution() throws IOException {
        BOJ3745 boj3745 = new BOJ3745();
        String p = "6\n" +
                "            5                2 1   4 5                        3\n" +
                "3\n" +
                "1 1 1\n" +
                "4\n" +
                "4 3 2 1\n" +
                "";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj3745.solution();
    }
}