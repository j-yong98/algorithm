package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4991Test {
    @Test
    void solution() throws IOException {
        BOJ4991 boj4991 = new BOJ4991();
        String p = "5 5\n" +
                "....*\n" +
                ".*.*.\n" +
                "..o..\n" +
                "..*..\n" +
                ".....\n" +
                "0 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4991.solution();
    }
}