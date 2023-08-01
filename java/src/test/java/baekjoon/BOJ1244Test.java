package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1244Test {
    @Test
    void solution() throws IOException {
        BOJ1244 boj1244 = new BOJ1244();
        String p = "8\n" +
                "0 1 0 1 0 0 0 1\n" +
                "2\n" +
                "1 3\n" +
                "2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1244.solution();
    }
}