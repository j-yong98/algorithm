package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11060Test {
    @Test
    void solution() throws IOException {
        BOJ11060 boj11060 = new BOJ11060();
        String p = "10\n" +
                "1 2 0 1 3 2 1 5 4 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11060.solution();
    }
}