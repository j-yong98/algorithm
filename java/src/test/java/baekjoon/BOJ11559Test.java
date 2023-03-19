package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ11559Test {
    @Test
    void solution() throws IOException {
        BOJ11559 boj11559 = new BOJ11559();
        String p = "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                ".Y....\n" +
                ".YG...\n" +
                "RRYG..\n" +
                "RRYGG.";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11559.solution();
    }
}