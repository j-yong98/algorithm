package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17070Test {
    @Test
    void solution() throws IOException {
        BOJ17070 boj17070 = new BOJ17070();
        String p = "6\n" +
                "0 0 0 0 0 0\n" +
                "0 1 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17070.solution();
    }
}