package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1063Test {
    @Test
    void solution() throws IOException {
        BOJ1063 boj1063 = new BOJ1063();
        String p = "A8 B7 18\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB\n" +
                "RB";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1063.solution();
    }
}