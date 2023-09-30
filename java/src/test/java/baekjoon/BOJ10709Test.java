package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10709Test {
    @Test
    void solution() throws IOException {
        BOJ10709 boj10709 = new BOJ10709();
        String p = "6 8\n" +
                ".c......\n" +
                "........\n" +
                ".ccc..c.\n" +
                "....c...\n" +
                "..c.cc..\n" +
                "....c...";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10709.solution();
    }
}