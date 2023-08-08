package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1043Test {
    @Test
    void solution() throws IOException {
        BOJ1043 boj1043 = new BOJ1043();
        String p = "4 5\n" +
                "1 1\n" +
                "1 1\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "2 4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1043.solution();
    }
}