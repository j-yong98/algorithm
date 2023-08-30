package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1865Test {
    @Test
    void solution() throws IOException {
        BOJ1865 boj1865 = new BOJ1865();
        String p = "2\n" +
                "3 3 1\n" +
                "1 2 2\n" +
                "1 3 4\n" +
                "2 3 1\n" +
                "3 1 3\n" +
                "3 2 1\n" +
                "1 2 3\n" +
                "2 3 4\n" +
                "3 1 8";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1865.solution();
    }
}