package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ14002Test {
    @Test
    void solution() throws IOException {
        BOJ14002 boj14002 = new BOJ14002();
        String p = "6\n" +
                "10 20 10 30 20 50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj14002.solution();
    }

}