package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1079Test {
    @Test
    void solution() throws IOException {
        BOJ1079 boj1079 = new BOJ1079();
        String p = "6\n" +
                "500 500 500 500 500 500\n" +
                "-3 -3 -3 -3 -3 -3\n" +
                "2 2 2 2 2 2\n" +
                "-4 -4 -4 -4 -4 -4\n" +
                "6 6 6 6 6 6\n" +
                "7 7 7 7 7 7\n" +
                "-8 -8 -8 -8 -8 -8\n" +
                "0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1079.solution();
    }
}