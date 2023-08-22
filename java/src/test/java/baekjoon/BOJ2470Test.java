package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ2470Test {
    @Test
    void solution() throws IOException {
        BOJ2470 boj2470 = new BOJ2470();
        String p = "5\n" +
                "-2 4 -99 -1 98";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj2470.solution();
    }
}