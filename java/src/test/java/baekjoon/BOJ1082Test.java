package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1082Test {
    @Test
    void solution() throws IOException {
        BOJ1082 boj1082 = new BOJ1082();
        String p = "10\n" +
                "1 1 1 1 1 1 1 1 1 1\n" +
                "50";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1082.solution();
    }
}