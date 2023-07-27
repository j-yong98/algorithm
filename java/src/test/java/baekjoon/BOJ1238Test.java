package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1238Test {
    @Test
    void solution() throws IOException {
        BOJ1238 boj1238 = new BOJ1238();
        String p = "4 8 2\n" +
                "1 2 4\n" +
                "1 3 2\n" +
                "1 4 7\n" +
                "2 1 1\n" +
                "2 3 5\n" +
                "3 1 2\n" +
                "3 4 4\n" +
                "4 2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1238.solution();
    }
}