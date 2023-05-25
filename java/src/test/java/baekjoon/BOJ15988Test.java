package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ15988Test {
    @Test
    void solution() throws IOException {
        BOJ15988 boj15988 = new BOJ15988();
        String p = "3\n" +
                "4\n" +
                "7\n" +
                "10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15988.solution();
    }
}