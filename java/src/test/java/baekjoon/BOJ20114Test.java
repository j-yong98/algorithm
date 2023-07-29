package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20114Test {
    @Test
    void solution() throws IOException {
        BOJ20114 boj20114 = new BOJ20114();
        String p = "6 2 3\n" +
                "???rrruuu???ttt???\n" +
                "f?f?rruuu?????t???";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20114.solution();
    }
}