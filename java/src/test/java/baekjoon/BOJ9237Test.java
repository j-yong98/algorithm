package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9237Test {
    @Test
    void solution() throws IOException {
        BOJ9237 boj9237 = new BOJ9237();
        String p = "6\n" +
                "39 38 9 35 39 20";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9237.solution();
    }
}