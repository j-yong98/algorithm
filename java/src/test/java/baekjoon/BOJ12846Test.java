package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ12846Test {
    @Test
    void solution() throws IOException {
        BOJ12846 boj12846 = new BOJ12846();
        String p = "5\n" +
                "10 20 30 20 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj12846.solution();
    }
}